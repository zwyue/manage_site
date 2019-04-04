package com.zr.gansu.web.controller;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.OptionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: yufei
 * @Description:调查问卷选项controller
 * @Date: Create in 18:02 2019/2/12
 */
@Api(value="调查问卷问题选项controller",tags={"调查问卷问题选项接口操作"})
@RestController
@RequestMapping("/member/option")
public class OptionController {

    private final
    OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    /**
     *@Author:yufei
     *@Description:删除调查问卷问题选项 逻辑删除
     *@Param: id 选项id
     *@return java.util.Map
     *@Date:2019/2/12_18:05
     */
    @Log
    @ApiOperation(value="修改问卷问题选项删除状态", notes="根据url的id删除调查问卷问题选项")
    @ApiImplicitParam(name = "id", value = "问卷问题选项ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteOption(@PathVariable(value = "id" )Long id){
        if(id != null){
            if(optionService.updateIsDeleted(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}
