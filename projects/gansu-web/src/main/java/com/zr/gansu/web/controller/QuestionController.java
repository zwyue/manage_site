package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Option;
import com.zr.gansu.domain.Question;
import com.zr.gansu.service.OptionService;
import com.zr.gansu.service.QuestionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:调查问卷的相关问题的controller
 * @Date: Create in 18:02 2018/12/28
 */
@Api(value="调查问卷问题controller",tags={"调查问卷问题接口操作"})
@RestController
@RequestMapping("/member/question")
public class QuestionController {

    private final
    QuestionService questionService;

    private final
    OptionService optionService;

    @Autowired
    public QuestionController(QuestionService questionService, OptionService optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }


    /**
     *@Author:yufei
     *@Description:新增问题并同步问题选项表
     *@Param: question 问卷问题信息
     *@return java.util.Map
     *@Date:2019/2/12_16:56
     */
    @Log
    @ApiOperation(value="创建问卷问题", notes="根据Question对象创建调查问卷问题")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addQuestion(@ApiParam(value = "调查问卷参数", required = true) @RequestBody Question question){
           if(ObjectUtil.isNotNull(question)){
               question.setGmtCreate(new Date());
               int result = questionService.insert(question);
               if(result>0){
                   if(question.getType()!=2){
                       //单选题或多选题
                       ArrayList<Option> options = question.getOptions();
                           for (Option option:options){
                               Option option1 = new Option();
                               option1.setOptions(option.getOptions());
                               option1.setContent(option.getContent());
                               option1.setGmtCreate(new Date());
                               option1.setQuestionId(question.getId());
                               optionService.insert(option1);
                       }
                   }
                   //添加成功后将问题的信息返回给前端页面展示
                   /* questionService.selectQuAndOptions(question.getId());*/
                   //返回问卷问题的id
                   return ResultUtils.success(question.getId(),ResultMsg.ADD_SUCESS.msg());
               }else{
                   return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
               }
           }else{
               return ResultUtils.error(ResultMsg.ADD_QUESTION_NOTNULL.msg());
           }
    }


    /**
     *@Author:yufei
     *@Description:查询问题和选项
     *@Param: id 问题id
     *@return java.util.Map
     *@Date:2019/2/12_18:08
     */
    @Log
    @ApiOperation(value="查询问卷问题详情", notes="根据url的id来指定查询问卷问题详情")
    @ApiImplicitParam(name = "id", value = "问卷问题ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getQuesAndOptions(@PathVariable(value = "id") Long id){
        if(id != null){
            Question question = questionService.selectQuAndOptions(id);
            if(ObjectUtil.isNotNull(question)){
                return ResultUtils.success(question);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:修改问题和选项
     *@Param: question 问题信息
     *@return java.util.Map
     *@Date:2019/2/12_18:09
     */
    @Log
    @ApiOperation(value="更新调查问卷问题信息", notes="根据Question对象更新调查问卷问题信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateQuestion(@ApiParam(value = "调查问卷参数", required = true) @RequestBody Question question){
        if(ObjectUtil.isNotNull(question)){
            question.setGmtModified(new Date());
            if(questionService.updateByPrimaryKeySelective(question)>0){
                if(question.getType()!=2){
                    //单选题或多选题
                    for(Option option:question.getOptions()){
                        Option option1 = new Option();
                        option1.setId(option.getId());
                        option1.setContent(option.getContent());
                        option1.setOptions(option.getOptions());
                        option1.setGmtModified(new Date());
                        optionService.updateByPrimaryKeySelective(option1);
                    }
                }
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }else{
                return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
            }
        }
        return ResultUtils.error(ResultMsg.ADD_QUESTION_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除问题信息 逻辑删除
     *@Param: id  问题id
     *@return java.util.Map
     *@Date:2019/2/12_18:10
     */
    @Log
    @ApiOperation(value="修改调查问卷问题删除状态", notes="根据url的id删除调查问卷问题")
    @ApiImplicitParam(name = "id", value = "问卷问题ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/update/isDeleted/{id}",method = RequestMethod.GET)
    public Map updateIsDeleted(@PathVariable(value = "id" )Long id){
        if(id != null){
            if(questionService.updateIsDeleted(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

}
