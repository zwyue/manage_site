package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.News;
import com.zr.gansu.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Author: yufei
 * @Description:新闻前台controller
 * @Date: Create in 9:14 2019/1/29
 */
@Api(value="新闻controller",tags={"新闻接口操作"})
@RestController
@RequestMapping("/member/news")
public class NewsController {

    private final
    NewsService newsService;


    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /**
     *@Author:yufei
     *@Description:根据子站id查询新闻列表 默认查询总站新闻
     *@Param: siteId  子站id
     *@return java.util.Map
     *@Date:2019/2/11_13:46
     */
    @Log
    @ApiOperation(value="查询网站首页新闻列表", notes="根据url的子站id来指定查询新闻列表")
    @ApiImplicitParam(name = "siteId", value = "子站id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/indexnews/{siteId}",method = RequestMethod.GET)
    public Map getNewsListBySiteId(@PathVariable(value = "siteId")Long siteId){
      List<News> newsList = newsService.getNewsListBySiteId(siteId);
      return ResultUtils.success(newsList);
    }

    /**
     *@Author:yufei
     *@Description:查询新闻咨询页更多新闻内容列表
     *@Param: pageNum 当前页
     *@Param: pageSize 每页大小
     *@Param: siteId 子站id
     *@return java.util.Map
     *@Date:2019/2/11_13:54
     */
    @Log
    @ApiOperation(value="查询新闻咨询列表", notes="根据子站siteId查询新闻咨询列表",produces = "application/json")
    @RequestMapping(value = "/morenews",method = RequestMethod.GET)
    public Map getNewsListMore(@ApiParam(value = "当前分页数", required = true,defaultValue = "1") @RequestParam Integer pageNum,
                               @ApiParam(value = "每页数量", required = true,defaultValue = "10") @RequestParam Integer pageSize,
                               @ApiParam(value = "子站id", required = true)@RequestParam Long siteId){
        //分页查询
        PageHelper.startPage(pageNum,pageSize,true);
        List<News> newsList = newsService.getNewsListMore(siteId);
        return ResultUtils.success(new PageInfo<>(newsList));
    }

    /**
     *@Author:yufei
     *@Description:查询新闻内容详情
     *@Param: id 新闻id
     *@return java.util.Map
     *@Date:2019/2/11_14:00
     */
    @Log
    @ApiOperation(value="查询新闻详情", notes="根据url的id来指定查询新闻")
    @ApiImplicitParam(name = "id", value = "新闻ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getNewsDetailById(@PathVariable(value = "id" )Long id){
        if(id != null){
           News news = newsService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(news)){
                return ResultUtils.success(news);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}
