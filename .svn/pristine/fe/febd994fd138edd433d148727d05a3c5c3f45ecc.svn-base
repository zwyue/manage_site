package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Tag;
import com.zr.gansu.service.NewsService;
import com.zr.gansu.service.TagService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:新增标签 后台Controller
 * @Date: Create in 15:22 2019/1/24
 */
@Api(value="新闻标签controller操作",tags={"新闻标签接口操作"})
@RestController
@RequestMapping("/admin/tag")
public class AdminTagController {

    @Resource
    private  TagService tagService;

    @Resource
    private  NewsService newsService;

    /**
     *@Author:yufei
     *@Description:查询新闻标签列表
     *@Param: pageNum 当前页
     *@Param: pageSize  每页数量
     *@return java.util.Map
     *@Date:2019/2/18_17:14
     */
    @Log
    @ApiOperation(value="查询后台新闻标签列表", notes="查询后台新闻标签列表",produces = "application/json")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map getNewsBackList(@ApiParam(value = "当前分页数", required = true,defaultValue = "1") @RequestParam Integer pageNum,
                               @ApiParam(value = "每页数量", required = true,defaultValue = "10") @RequestParam Integer pageSize) {
        //分页查询
        PageHelper.startPage(pageNum, pageSize, true);
        List<Tag> tagList = tagService.getTagList();
        return ResultUtils.success(new PageInfo<>(tagList));
    }


    /**
     *@Author:yufei
     *@Description: 新增新闻标签
     *@Param: tag 标签对象
     *@return java.util.Map
     *@Date:2019/1/24_10:01
     */
    @Log
    @ApiOperation(value="创建新闻标签", notes="根据Tag对象创建新闻标签")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addTag(@ApiParam(value = "新闻标签参数", required = true)@RequestBody  Tag tag){
        if(ObjectUtil.isNotNull(tag)){
            tag.setGmtCreate(new Date());
            if(tagService.insert(tag)>0){
                return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_NEWS_NOTNULL.msg());
    }


    /**
     *@Author:yufei
     *@Description:修改新闻标签
     *@Param: tag 标签对象
     *@return java.util.Map
     *@Date:2019/1/24_10:12
     */
    @Log
    @ApiOperation(value="更新新闻标签", notes="根据Tag对象更新新闻标签信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateTag(@ApiParam(value = "新闻标签参数", required = true)@RequestBody Tag tag){
        if(ObjectUtil.isNotNull(tag)) {
            tag.setGmtModified(new Date());
            if (tagService.updateByPrimaryKeySelective(tag)>0) {
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_NEWS_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除新闻标签
     *@Param: tagId 标签id
     *@return java.util.Map
     *@Date:2019/1/24_10:23
     */
    @Log
    @ApiOperation(value="删除新闻标签", notes="根据url的新闻id删除新闻标签")
    @ApiImplicitParam(name = "id", value = "新闻标签ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteTag(@PathVariable(value = "id" )Long id){
        if(id != null){
            //查询此Tag标签下是否存在新闻  没有新闻才能删除该标签
            if(newsService.countNews(id)>0){
                return ResultUtils.error(ResultMsg.TAG_HAVE_NEWS.msg());
            }
            //执行删除操作
            if(tagService.deleteByPrimaryKey(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:查询新闻标签
     *@Param: id
     *@return java.util.Map
     *@Date:2019/1/24_11:14
     */
    @Log
    @ApiOperation(value="查询新闻标签详情", notes="根据url的id来指定查询新闻标签")
    @ApiImplicitParam(name = "id", value = "新闻标签ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getNewsByTagId(@PathVariable(value = "id") Long id){
        if(id != null){
            Tag tag = tagService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(tag)){
                return ResultUtils.success(tag);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}
