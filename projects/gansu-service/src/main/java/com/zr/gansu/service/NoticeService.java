package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.Notice;
import com.zr.gansu.domain.NoticeText;
import com.zr.gansu.vo.NoticesVo;

/***
 * @Author wanglidong
 * @Description 通知公告逻辑层
 * @Date 2019/2/12 15:03
 *
**/
public interface NoticeService {
    /**
     * 添加公告内容
      * @param noticeText
     * @return 主键id
     */
   int addNoticeContent(NoticeText noticeText);

    /**
     * 添加通知公告相关信息
     * @param notice
     * @return
     */
   int addNotices(Notice notice);

    /**
     * 添加课程公告
     * @param notice
     * @return
     */
   int addCourseNotices(Notice notice);

   PageInfo queryNotice(Integer pageNum,Integer pageSize,Long siteId);

   PageInfo queryNoticeByCourse(long courseId,Integer pageNum,Integer pageSize);

   NoticesVo queryNoticeById(long noticeId);

   int delNotices(long noticeId);

   int modifyNotice(Notice notice,String text);

}
