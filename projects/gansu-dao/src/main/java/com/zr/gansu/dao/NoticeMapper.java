package com.zr.gansu.dao;

import com.zr.gansu.domain.Notice;
import com.zr.gansu.vo.NoticesVo;

import java.util.List;

public interface NoticeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Long id);

    List<Notice> queryAllNotice(Long site);

    List<Notice> queryNoticeByCourse(long courseId);

    NoticesVo queryNoticeById(long noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectBycourseId(Long lessonId);
}