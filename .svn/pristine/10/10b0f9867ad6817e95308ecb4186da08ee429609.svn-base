package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.NoticeService;
import com.zr.gansu.vo.NoticesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName NoticeController
 *@Desciption 通知公告控制层
 *@Author Administrator
 *@Date 2019/2/12 15:00
 */
@Api(value = "前端显示通知公告信息",tags = "查询公告信息")
@Controller
@RequestMapping("/notice")
public class NoticeController {

   @Resource
    private NoticeService noticeService;

    /***
     * @Author wanglidong
     * @Description 查询首页公告相关信息(除课程公告)
     * @Date 2019/2/13 9:36
     * @Param [page, pageSize]
     * @return java.util.Map
     **/
    @Log
    @ApiOperation(value = "查询通知公告",notes = "分页查询通知公告内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value="queryNotice",method = RequestMethod.GET)
    public Map queryNotice(
            @ApiParam(name ="pageNum",value = "当前页码数",required = true)
            @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
            @ApiParam(name ="pageSize",value = "每页显示个数",required = true)
            @RequestParam(name="pageSize",defaultValue = "10") Integer  pageSize,
            @ApiParam(name ="siteId",value = "子站id",required = true)
            @RequestParam(name = "siteId") Long siteId){
        PageInfo pageInfo = noticeService.queryNotice(pageNum, pageSize,siteId);
        return ResultUtils.success(pageInfo,ResultMsg.SUCCESS.msg());
    }

    /***
     * @Author wanglidong
     * @Description 根据公告id查看公告内容信息
     * @Date 2019/2/13 11:31
     * @Param [noticeId]
     * @return java.util.Map
     **/
    @Log
    @ApiOperation(value = "查看公告内容",notes = "根据id查看公告内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/viewNotice",method = RequestMethod.GET)
    public Map viewNotice(@ApiParam(name = "noticeId",value = "noticeId通知公告id",required = true) @RequestParam(name="noticeId") long noticeId){
        NoticesVo noticesVo = noticeService.queryNoticeById(noticeId);
        if(ObjectUtil.isNotNull(noticesVo)){
            return ResultUtils.success(noticesVo,ResultMsg.SUCCESS.msg());
        }
        return ResultUtils.error("该条记录不存在，如有疑问联系管理员！");
    }
}
