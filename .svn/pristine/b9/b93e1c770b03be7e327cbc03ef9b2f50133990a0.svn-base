package com.zr.gansu.manage.controller;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.OldAgeActivity;
import com.zr.gansu.domain.OldAgeActivityText;
import com.zr.gansu.form.OldAgeActivityForm;
import com.zr.gansu.service.OldAgeEduService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 老年教育控制器
 *
 * @author yuyi
 */
@Api(value = "老年教育",tags = "老年教育")
@RestController
@RequestMapping("/admin/oldAgeEdu")
public class AdminOldAgeEduController {
    @Autowired
    private OldAgeEduService oldAgeEduService;

    /**
     * 添加老年活动
     *
     * @author yuyi
     *
     * @param oldAgeActivityForm 添加参数
     *
     */
    @Log
    @ApiOperation(value = "添加活动",notes ="添加活动内容 : 老年活动/兴趣课程")
    @PostMapping("/add")
    public Map addOldAgeActivity(
            @ApiParam(value = "活动/课程参数",required = true)
            @RequestBody OldAgeActivityForm oldAgeActivityForm) {
        //添加老年活动
        oldAgeEduService.addOldAgeActivity(oldAgeActivityForm);
        return ResultUtils.success(true,"添加成功");
    }

    /**
     * 删除老年活动
     *
     * @author yuyi
     *
     * @param id
     *
     * @return
     */
    @Log
    @ApiOperation(value = "删除活动",notes ="删除活动内容: 老年活动/兴趣课程")
    @PostMapping("/delete")
    public Map deleteOldAgeActivity(Long id) {
        oldAgeEduService.deleteOldAgeActivity(id);
        return ResultUtils.success(true,"删除成功");
    }

    /**
     * 修改年活动
     *
     * @author yuyi
     *
     * @param oldAgeActivityForm 添加参数
     *
     */
    @Log
    @ApiOperation(value = "修改活动",notes ="修改活动内容: 老年活动/兴趣课程")
    @PostMapping("/modify")
    public Map modifyOldAgeActivity(
            @ApiParam(value = "活动参数",required = true)
            @RequestBody OldAgeActivityForm oldAgeActivityForm) {
        //添加老年活动
        oldAgeEduService.modifyOldAgeActivity(oldAgeActivityForm);
        return ResultUtils.success(true,"修改成功");
    }

    /**
     * 分页查询活动
     *
     * @author yuyi
     *
     * @param page
     *
     * @param size
     *
     * @return list
     */
    @Log
    @ApiOperation(value = "分页查询活动",notes ="分页查询活动: 老年活动/兴趣课程")
    @GetMapping("/list")
    public Map listOldAgeActivity(Integer type,Integer page,Integer size) {
        PageInfo<OldAgeActivity> pageInfo = oldAgeEduService.findByPagination(type,page,size);
        return ResultUtils.success(pageInfo,"查询成功");
    }

    /**
     * 查询活动明细
     *
     * @param id
     *
     * @return
     */
    @Log
    @ApiOperation(value = "查询活动明细",notes ="查询活动明细: 老年活动/兴趣课程")
    @GetMapping("/details")
    public Map queryActivityDetails(Long id) {
        OldAgeActivity oldAgeActivity = oldAgeEduService.findByActivityId(id);
        return ResultUtils.success(oldAgeActivity,"查询成功");
    }

    /**
     * 查询活动内容明细
     *
     * @param id
     *
     * @return
     */
    @Log
    @ApiOperation(value = "查询活动内容明细",notes ="查询活动内容明细: 老年活动/兴趣课程")
    @GetMapping("/contentDetails")
    public Map queryContentDetails(Long id) {
        OldAgeActivityText oldAgeActivityText = oldAgeEduService.findByContentId(id);
        return ResultUtils.success(oldAgeActivityText,"查询成功");
    }

}
