package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.BonusType;
import com.zr.gansu.service.BonusTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName AdminBonusTypeController
 *@Desciption 自定义加分类型
 *@Author Administrator
 *@Date 2019/2/25 10:46
 *@return
 */
@Api(value = "自定义加分类型",tags = "加分类型")
@Controller
@RequestMapping("/admin/bonusType")
public class AdminBonusTypeController {

    @Resource
    private BonusTypeService bonusTypeService;

    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "添加加分类型",notes = "添加加分类型")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addBonusType(
            @ApiParam(name = "typeName",value ="加分类型名称",required = true)
            @RequestParam(name = "typeName") String typeName,
            @ApiParam(name = "scores",value ="分值",required = true)
            @RequestParam(name = "scores")  Long scores){

            if(ObjectUtil.isNotNull(typeName)&&ObjectUtil.isNotNull(scores)){
                Integer status = bonusTypeService.addBonusType(typeName, scores);
                if(status.equals(Constants.REPEATED_SUBMIT)){
                    return ResultUtils.error("该类型已存在!");
                }else if(status.equals(Constants.EXECUTE_FAIL)){
                    return ResultUtils.error("添加失败!");
                }else{
                    return ResultUtils.success("添加成功!");
                }
            }
        return ResultUtils.error("添加的内容不能为空!");
    }

    @Log
    @ResponseBody
    @ApiOperation(value = "查询加分类型",notes = "查询加分类型")
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public Map queryBonusType(@ApiParam(name = "pageNum",value = "当前页码数")
                              @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNume,
                              @ApiParam(name = "pageSize",value = "每页数")
                              @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize){
        PageInfo pageInfo = bonusTypeService.queryBonusType(pageNume, pageSize);

        return ResultUtils.success(pageInfo);
    }

    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "根据id修改内容",notes = "根据id修改内容")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Map modifyBonusType(@ApiParam(name = "id",value ="id",required = true)
                               @RequestParam(name = "id") Long id,
                               @ApiParam(name = "typeName",value ="加分类型名称")
                               @RequestParam(name = "typeName") String typeName,
                               @ApiParam(name = "scores",value ="分值")
                               @RequestParam(name = "scores")  Long scores){
        if(ObjectUtil.isNotNull(id)){
            Integer status = bonusTypeService.modifyBonusType(id, typeName, scores);
            if(status.equals(Constants.REPEATED_SUBMIT)){
                return ResultUtils.error("该类型已存在!");
            }else if(status.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.error("修改失败!");
            }else{
                return ResultUtils.success("修改成功！");
            }
        }
        return ResultUtils.error("修改失败!");
    }


    @Log
    @ResponseBody
    @ApiOperation(value = "根据id修改内容",notes = "根据id修改内容")
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public Map queryBonusTypeById(@ApiParam(name = "id",value ="Id",required = true)
                                  @RequestParam(name = "id") Long id){
        BonusType bonusType = bonusTypeService.queryBonusTypeById(id);
        if(ObjectUtil.isNotNull(bonusType)){
            return ResultUtils.success(bonusType);
        }
        return ResultUtils.error("你查看的信息不存在!");
    }

    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "删除此类型",notes = "删除此类型")
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Map delBonusType(@ApiParam(name = "id",value ="Id",required = true)
                            @RequestParam(name = "id") Long id){
        Integer status = bonusTypeService.delBonusTypeById(id);
        if(!status.equals(Constants.EXECUTE_FAIL)){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败！");
    }
}
