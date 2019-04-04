package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Notice;
import com.zr.gansu.domain.NoticeText;
import com.zr.gansu.domain.Site;
import com.zr.gansu.service.NoticeService;
import com.zr.gansu.service.SiteService;
import com.zr.gansu.vo.NoticesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName NoticeController
 *@Desciption 通知公告控制层
 *@Author Administrator
 *@Date 2019/2/12 15:00
 */
@Api(value = "通知公告管理层",tags = "通知公告管理层")
@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {

    @Resource
    private NoticeService noticeService;
    @Resource
    private SiteService siteService;

    /***
     * @Author wanglidong
     * @Description 添加通知公告内容
     * @Date 2019/2/12 15:15
     * @Param []
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "新增通知公告",notes = "添加公告内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/addNotice" ,method = RequestMethod.POST)
    public Map addNotice(
           @ApiParam(value = "通知公告标题",required = true) @RequestParam(name = "title") String title,
           @ApiParam(value = "通知公告内容",required = true)@RequestParam(name = "text") String text,
           @ApiParam(value = "所属子站id",required = true)@RequestParam(name = "siteId") Long siteId){
        if(ObjectUtil.isNotNull(title)&&ObjectUtil.isNotNull(text)&&ObjectUtil.isNotNull(siteId)) {
            //判断该子站是否存在
            Site site = siteService.selectByPrimaryKey(siteId);
            if (ObjectUtil.isNotNull(site) &&Constants.IS_DELETED_NO.equals(site.getIsDeleted())) {
                //添加通知公告内容
                NoticeText noticeText = new NoticeText();
                noticeText.setContent(text);
                Integer statusContent = noticeService.addNoticeContent(noticeText);
                if (!statusContent.equals(Constants.EXECUTE_FAIL)) {
                    //添加通知公告相关信息
                    Notice notice = new Notice();
                    notice.setSiteId(siteId);
                    notice.setTitle(title);
                    notice.setContentId(noticeText.getId());
                    Integer status = noticeService.addNotices(notice);
                    if(!status.equals(Constants.EXECUTE_FAIL)) {
                        return ResultUtils.success("添加成功！");
                    }
                }
                return ResultUtils.error("添加失败");
            }else{
                return ResultUtils.error("子站信息不存在!");
            }
        }
        return  ResultUtils.error("通知公告相关内容不能为空!");
    }

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
            @RequestParam(name="siteId") Long siteId){
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
    /***
     * @Author wanglidong
     * @Description  删除公告内容
     * @Date 2019/2/12 17:18
     * @Param [id]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "删除通知公告",tags = "根据id删除公告内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/delNotice",method = RequestMethod.POST)
    public Map deleteNotice(@ApiParam(name = "noticeId",value = "noticeId通知公告id",required = true) @RequestParam(name="noticeId")long noticeId){
        Integer status = noticeService.delNotices(noticeId);
        if(!status.equals(Constants.EXECUTE_FAIL)){
            if(status.equals(Constants.IS_DELETED_ALREADY)){
                    //记录已被删除，不可重复操作
                return ResultUtils.error("请勿重复操作!");
            }
            return ResultUtils.success("删除成功！");
        }
        return ResultUtils.error("删除失败！");
    }
    /***
     * @Author wanglidong
     * @Description  修改公告内容
     * @Date 2019/2/12 17:49
     * @Param [id]
     * @return java.util.Map
    **/
    @ApiOperation(value = "修改通知公告",notes = "根据id修改公告")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/modifyNotice",method =RequestMethod.POST)
    public Map modifyNotice(@ApiParam(name ="noticeId",value = "通知公告id",required = true)
                            @RequestParam(name="noticeId")long noticeId,
                            @ApiParam(name ="title",value = "标题")
                            @RequestParam(name="title") String title,
                            @ApiParam(name = "text",value = "公告内容")
                            @RequestParam(name="text")   String text){

        if(ObjectUtil.isNotNull(noticeId)){
            Notice notice=new Notice();
            notice.setId(noticeId);
            notice.setTitle(title);
            Integer modifyStatus= noticeService.modifyNotice(notice, text);
            if(!modifyStatus.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.success("修改成功！");
            }
        }
        return ResultUtils.error("修改失败!");
    }

}
