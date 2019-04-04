package com.zr.gansu.service.impl;


import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.NoticeMapper;
import com.zr.gansu.dao.NoticeTextMapper;
import com.zr.gansu.domain.Notice;
import com.zr.gansu.domain.NoticeText;
import com.zr.gansu.service.CourseNoticeService;
import com.zr.gansu.vo.CourseNoticeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NoticeServiceImpl
 * @Author Administrator
 * @Date 2019/2/14 15:16
 */
@Service
public class CourseNoticeServiceImpl implements CourseNoticeService {
    @Resource
    private NoticeMapper noticeMapper;
    @Resource
    private NoticeTextMapper noticeTextMapper;

    /**
     * @Author liuhuan
     * @Description 发布课程公告
     * @Date 17:12 2019/2/14
     * @Param [noticeTitle, noticeTextId, lessonId, userId]
     * @return java.util.Map
     **/
    @Override
    public Map addNotice(String noticeTitle, Long noticeTextId, Long lessonId, Long userId) {
        //插入相关数据
        Notice notice = new Notice();
        notice.setContentId(noticeTextId);
        notice.setCreatorId(userId);
        notice.setGmtCreate(new Date());
        notice.setTitle(noticeTitle);
        notice.setLessonId(lessonId);
        notice.setIsCourse(Constants.IS_COURSE_NOTICE_YES);
        noticeMapper.insert(notice);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 查看该课程所有公告
     * @Date 15:47 2019/2/21
     * @Param [courseId]
     * @return java.util.Map
     **/
    @Override
    public Map selectAllNotice(Long lessonId) {
        List<Notice> noticeList = noticeMapper.selectBycourseId(lessonId);
        List<CourseNoticeVo> courseNoticeVoList = new ArrayList<>();
        CourseNoticeVo courseNoticeVo = new CourseNoticeVo();
        for (int i=0;i<noticeList.size();i++){
            Long NoticeTextId = noticeList.get(i).getContentId();
            NoticeText noticeText = noticeTextMapper.selectByPrimaryKey(NoticeTextId);
            courseNoticeVo.setContent(noticeText.getContent());
            courseNoticeVo.setContentId(noticeList.get(i).getContentId());
            courseNoticeVo.setCreatorId(noticeList.get(i).getCreatorId());
            courseNoticeVo.setTitle(noticeList.get(i).getTitle());
            courseNoticeVo.setGmtCreate(noticeList.get(i).getGmtCreate());
            courseNoticeVo.setLessonId(noticeList.get(i).getLessonId());
            courseNoticeVoList.add(i,courseNoticeVo);
        }
        return ResultUtils.success(courseNoticeVoList,ResultMsg.FIND_SUCCESS.msg());
    }
}
