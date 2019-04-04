package com.zr.gansu.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Answer;
import com.zr.gansu.domain.AnswerExample;
import com.zr.gansu.service.AnswerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:用户调查问卷回答Controller
 * @Date: Create in 9:30 2019/2/14
 */
@Api(value="调查问卷问题回复controller",tags={"调查问卷问题回复接口操作"})
@RestController
@RequestMapping("/member/answer")
public class AnswerController {

    private final
    AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     *@Author:yufei
     *@Description:保存用户调查问卷提交结果
     *@Param: answerExample 用户回答问卷信息
     *@return java.util.Map
     *@Date:2019/2/14_10:20
     */
    @Log
    @ApiOperation(value="保存调查问卷问题回复", notes="根据AnswerExample对象保存调查问卷问题回复")
    @ApiResponses({
            @ApiResponse(code=1,message="提交成功"),
            @ApiResponse(code=0,message="提交失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addAnswer(@ApiParam(value = "调查问卷问题回复参数", required = true) @RequestBody AnswerExample answerExample){
        if(ObjectUtil.isNotNull(answerExample)){
            //逐条保存用户作答结果
            for(Answer answer:answerExample.getAnswers()){
                answer.setGmtCreate(new Date());
                //获取用户id
                answer.setUserId(3L);
                answer.setQuestionnaireId(answerExample.getQuestionnaireId());
                answerService.insert(answer);
            }
            return  ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
        }
       return  ResultUtils.error(ResultMsg.ADD_ANSWER_NOTNULL.msg());
    }


    /**
     *@Author:yufei
     *@Description:查询对应问题id的选项情况所占百分比
     *@Param: questionId  问题id
     *@return java.util.Map
     *@Date:2019/2/14_15:02
     */
    @Log
    @ApiOperation(value="查询单个问卷问题统计百分比", notes="查询单个问卷问题统计百分比")
    @ApiImplicitParam(name = "questionId", value = "问题ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/count/{questionId}",method = RequestMethod.GET)
    public Map countPercent(@PathVariable(value = "questionId") Long questionId){
        if(questionId != null){
            //检查数据库中是否存在问题id，如无返回对应信息
            if(CollUtil.isNotEmpty(answerService.selectByPrimaryKey(questionId))){
                //查询出问题选项（A,B,C,D）所占百分比返回前台
                Map map = answerService.countPercent(questionId);
                if(CollUtil.isNotEmpty(map)){
                    return ResultUtils.success(map);
                }
                return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
            }else{
                return ResultUtils.error(ResultMsg.QUESTION_ID_NOT_EXIST.msg());
            }
        }
        return  ResultUtils.error(ResultMsg.ADD_QUESTION_ID_NOTNULL.msg());
    }


}
