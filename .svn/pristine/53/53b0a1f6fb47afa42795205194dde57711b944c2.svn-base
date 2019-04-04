package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.News;
import com.zr.gansu.domain.Tag;
import com.zr.gansu.domain.vo.NewsVo;
import com.zr.gansu.service.NewsService;
import com.zr.gansu.service.TagService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:新闻后台controller
 * @Date: Create in 9:14 2019/1/29
 */

@Api(value="新闻controller",tags={"新闻接口操作"})
@RestController
@RequestMapping("/admin/news")

public class AdminNewsController {

    @Resource
    private  NewsService newsService;

    @Resource
    private  TagService tagService;


    /**
     * @return java.util.Map
     * @Author:yufei
     * @Description:查询后台新闻列表
     * @Param: pageNum 当前分页数
     * @Param: pageSize 每页总数
     * @Param: siteId  子站id
     * @Date:2019/2/11_10:10
     */
    @Log
    @ApiOperation(value="查询后台新闻列表", notes="根据子站siteId查询新闻列表",produces = "application/json")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map getNewsBackList(@ApiParam(value = "当前分页数", required = true,defaultValue = "1") @RequestParam Integer pageNum,
                               @ApiParam(value = "每页数量", required = true,defaultValue = "10") @RequestParam Integer pageSize,
                               @ApiParam(value = "子站id", required = true)@RequestParam Long siteId) {
        //分页查询
        PageHelper.startPage(pageNum, pageSize, true);
        List<News> newsList = newsService.getNewsBackList(siteId);
        return ResultUtils.success(new PageInfo<>(newsList));
    }

    /**
     *@Author:yufei
     *@Description:获取新闻标签列表
     *@Param:  null
     *@return java.util.Map
     *@Date:2019/2/11_10:54
     */
    @Log
    @ApiOperation(value="查询新闻标签列表", notes="获取新闻标签列表")
    @RequestMapping(value = "/taglist",method = RequestMethod.GET)
    public Map getTagList(){
        List<Tag> tagList= tagService.getTagList();
        return ResultUtils.success(tagList);
    }


    /**
     *@Author:yufei
     *@Description:新增新闻信息
     *@Param: newsVo 新闻增强类信息
     *@return java.util.Map
     *@Date:2019/2/15_9:57
     */
    @Log
    @ApiOperation(value="创建新闻", notes="根据NewsExample对象创建新闻信息")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addNews(@ApiParam(value = "新闻参数", required = true) @RequestBody NewsVo newsVo){
        if(ObjectUtil.isNotNull(newsVo)){
            if( newsService.insertSelective(newsVo)>0){
                return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_NEWS_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:查询新闻详情
     *@Param: id
     *@return java.util.Map
     *@Date:2019/2/11_10:17
     */
    @Log
    @ApiOperation(value="查询新闻详情", notes="根据url的id来指定查询新闻")
    @ApiImplicitParam(name = "id", value = "新闻ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Map getNewsDetail(@PathVariable(value = "id")  Long id){
        if(id != null){
            News news = newsService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(news)){
                return ResultUtils.success(news);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:修改新闻信息
     *@Param: newsVo 新闻增强类信息
      *@return java.util.Map
     *@Date:2019/2/15_9:56
     */
    @Log
    @ApiOperation(value="更新新闻", notes="根据NewsExample对象更新新闻信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateNews(@ApiParam(value = "新闻参数", required = true) @RequestBody NewsVo newsVo) {
        if (ObjectUtil.isNotNull(newsVo)) {
            if(newsService.updateByPrimaryKeySelective(newsVo)>0){
               return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_NEWS_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除新闻信息 逻辑删除
     *@Param: id 新闻id
     *@return java.util.Map
     *@Date:2019/2/11_10:56
     */
    @Log
    @ApiOperation(value="删除新闻", notes="根据url的新闻id删除新闻")
    @ApiImplicitParam(name = "id", value = "新闻ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteNews(@PathVariable(value = "id" )Long id){
        if(id != null){
            if(newsService.deleteNewsById(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}


