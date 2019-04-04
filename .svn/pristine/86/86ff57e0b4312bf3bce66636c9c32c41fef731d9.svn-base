package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Questionnaire;
import com.zr.gansu.service.QuestionnaireService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:调查问卷的Controller
 * @Date: Create in 16:40 2018/12/28
 */
@Api(value="调查问卷controller",tags={"调查问卷接口操作"})
@RestController
@RequestMapping("/member/questionnaire")
public class QuestionnaireController {

    private final
    QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    /**
     *@Author:yufei
     *@Description:
     *@Param: id  问卷id查询整套调查问卷
     *@return java.util.Map
     *@Date:2019/2/12_15:14
     */
    @Log
    @ApiOperation(value="查询整套调查问卷", notes="根据url的问卷id查询整套问卷")
    @ApiImplicitParam(name = "id", value = "问卷ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/all/{id}",method = RequestMethod.GET)
    public Map findQuestionnaire(@PathVariable(value = "id") Long id){
        if(id != null){
            Questionnaire questionnaire = questionnaireService.selectQuestionnaire(id);
            if(ObjectUtil.isNotNull(questionnaire)){
                return ResultUtils.success(questionnaire);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:新增调查问卷
     *@Param: questionnaire  调查问卷信息
     *@return java.util.Map
     *@Date:2019/2/12_14:55
     */
    @Log
    @ApiOperation(value="创建调查问卷", notes="根据Questionnaire对象创建调查问卷")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addQuestionnaire(@ApiParam(value = "调查问卷参数", required = true) @RequestBody Questionnaire questionnaire){
        if(ObjectUtil.isNotNull(questionnaire)){
            //添加用户id
            questionnaire.setCreatorId(1L);
            questionnaire.setGmtCreate(new Date());
            if(questionnaireService.insert(questionnaire)>0){
                //返回新增的问卷主键id传到前台
                return ResultUtils.success(questionnaire.getId(),ResultMsg.ADD_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_QUESTIONNAIRE_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:查询问卷基本信息
     *@Param: id   问卷id
     *@return java.util.Map
     *@Date:2019/2/12_15:01
     */
    @Log
    @ApiOperation(value="查询问卷详情", notes="根据url的id来指定查询问卷详情")
    @ApiImplicitParam(name = "id", value = "问卷ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getQuestionnaire(@PathVariable(value = "id")Long id){
        if(id != null){
            Questionnaire questionnaire = questionnaireService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(questionnaire)){
                return ResultUtils.success(questionnaire);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description: 修改问卷调查基本信息
     *@Param: questionnaire 问卷调查基本信息
     *@return java.util.Map
     *@Date:2019/2/12_15:04
     */
    @Log
    @ApiOperation(value="更新调查问卷基本信息", notes="根据Questionnaire对象更新调查问卷基本信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateQuestionnaire(@ApiParam(value = "调查问卷参数", required = true) @RequestBody Questionnaire questionnaire){
        if(ObjectUtil.isNotNull(questionnaire)){
            questionnaire.setGmtModified(new Date());
            if(questionnaireService.updateByPrimaryKeySelective(questionnaire)>0){
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_QUESTIONNAIRE_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除未保存状态下的问卷调查信息
     *@Param: id  问卷id
     *@return java.util.Map
     *@Date:2019/2/12_15:06
     */
    @Log
    @ApiOperation(value="删除调查问卷", notes="根据url的id删除调查问卷")
    @ApiImplicitParam(name = "id", value = "问卷ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteQuestionnaire(@PathVariable(value = "id")Long questionnaireId){
        if(questionnaireId != null){
            if(questionnaireService.deleteQuestionnaire(questionnaireId)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除调查问卷信息 逻辑删除
     *@Param: id  问卷id
     *@return java.util.Map
     *@Date:2019/2/12_15:09
     */
    @Log
    @ApiOperation(value="修改调查问卷删除状态", notes="根据url的id删除调查问卷")
    @ApiImplicitParam(name = "id", value = "问卷ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/update/isDelete/{id}",method = RequestMethod.GET)
    public Map updateIsDeleted(@PathVariable(value = "id")Long id){
        if(id != null){
            if(questionnaireService.updateIsDeleted(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:修改调查问卷状态为发布状态
     *@Param: id   问卷id
     *@return java.util.Map
     *@Date:2019/2/12_15:10
     */
    @Log
    @ApiOperation(value="发布调查问卷", notes="根据url的id发布调查问卷")
    @ApiImplicitParam(name = "id", value = "问卷ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="发布成功"),
            @ApiResponse(code=0,message="发布失败")
    })
    @RequestMapping(value = "/update/status/{id}",method = RequestMethod.GET)
    public Map updateStatus(@PathVariable(value = "id")Long id){
        if(id != null){
            if(questionnaireService.updateStatus(id)>0){
                return ResultUtils.success(ResultMsg.RELEASE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.RELEASE_SUCESS.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

}
