package com.zr.gansu.web.controller;


import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Tag;
import com.zr.gansu.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:新闻标签tagController
 * @Date: Create in 9:43 2018/12/24
 */
@Api(value="新闻标签controller",tags={"新闻标签接口操作"})
@RestController
@RequestMapping("/member/tag")
public class TagController {

    private final
    TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    /**
     *@Author:yufei
     *@Description:查询新闻标签列表
     *@return java.util.Map
     *@Date:2019/1/24_10:13
     */
    @Log
    @ApiOperation(value="查询新闻标签列表", notes="获取新闻标签列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map getTagList(){
        List<Tag> tagList= tagService.getTagList();
        return ResultUtils.success(tagList);
    }

}
