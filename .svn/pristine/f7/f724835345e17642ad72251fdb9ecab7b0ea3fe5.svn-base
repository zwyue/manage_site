package com.zr.gansu.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.NoticeMapper;
import com.zr.gansu.dao.NoticeTextMapper;
import com.zr.gansu.domain.Notice;
import com.zr.gansu.domain.NoticeText;
import com.zr.gansu.service.NoticeService;
import com.zr.gansu.vo.NoticesVo;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName NoticeServiceImpl
 *@Desciption TODO
 *@Author wanglidong
 *@Date 2019/2/12 15:04
 *@return
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeTextMapper noticeTextMapper;

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public int addNoticeContent(NoticeText noticeText) {
          return  noticeTextMapper.insertSelective(noticeText);
    }

    @Override
    public int addNotices(Notice notice) {
        //补充相关信息 TODO  创建者信息未加
        //获取当前系统时间
        Date timeNow=new Date(System.currentTimeMillis());
        notice.setGmtCreate(timeNow);
        notice.setGmtModified(timeNow);
        notice.setIsCourse(Constants.IS_COURSE_NOTICE_NO);
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int addCourseNotices(Notice notice) {
        //补充相关信息 TODO  创建者信息未加
        //获取当前系统时间
        Date timeNow=new Date(System.currentTimeMillis());

        notice.setGmtCreate(timeNow);
        notice.setGmtModified(timeNow);
        return noticeMapper.insertSelective(notice);

    }

    @Override
    public PageInfo queryNotice(Integer pageNum, Integer pageSize,Long siteId) {
        PageHelper.startPage(pageNum,pageSize,"gmt_create desc");
        if(ObjectUtil.isNotNull(siteId)){
            List<Notice> notices = noticeMapper.queryAllNotice(siteId);
            PageInfo<Notice> pageInfo=new PageInfo(notices);
            return pageInfo;
        }else{
            return new PageInfo(null);
        }
    }

    @Override
    public PageInfo queryNoticeByCourse(long courseId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,"gmt_create desc");
        List<Notice> notices = noticeMapper.queryNoticeByCourse(courseId);
        PageInfo<Notice> pageInfo=new PageInfo<>(notices);
        return pageInfo;
    }

    @Override
    public NoticesVo queryNoticeById(long noticeId) {
        return noticeMapper.queryNoticeById(noticeId);
    }

    @Override
    public int delNotices(long noticeId) {
        //先删除公告内容
        Notice notice = noticeMapper.selectByPrimaryKey(noticeId);
        if(notice!=null){
            if(notice.getIsDeleted().equals(Constants.IS_DELETED_YES)){
                //该记录已被删除
                return 2;
            }else if(notice.getIsCourse().equals(Constants.IS_COURSE_NOTICE_YES)){
                    return 0;
            }else{
                //修改为已删除状态
                notice.setIsDeleted(Constants.IS_DELETED_YES);
                return noticeMapper.updateByPrimaryKey(notice);
            }
        }
        return 0;
    }

    @Override
    public int modifyNotice(Notice notice,String text) {
        //修改公告内容
        if(notice.getId()!=null){
            //查询是否存在这个信息
            Notice selectNotice = noticeMapper.selectByPrimaryKey(notice.getId());
            if(selectNotice!=null){
                //更新这条信息
                notice.setGmtModified(new Date(System.currentTimeMillis()));
                Integer  status = noticeMapper.updateByPrimaryKeySelective(notice);
                if(!status.equals(Constants.EXECUTE_FAIL)){
                    //再更新公告内容
                    NoticeText noticeText=new NoticeText();
                    noticeText.setId(selectNotice.getContentId());
                    noticeText.setContent(text);
                   return noticeTextMapper.updateByPrimaryKeySelective(noticeText);
                }else{
                    return 0;
                }
            }
        }
        return 0;
    }

}
