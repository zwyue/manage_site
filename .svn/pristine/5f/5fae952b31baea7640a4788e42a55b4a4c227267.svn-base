package com.zr.gansu.web.controller;

import com.zr.gansu.domain.Course;
import com.zr.gansu.service.CourseNoticeService;
import com.zr.gansu.service.CourseService;
import com.zr.gansu.service.NoticeTextService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CourseNoticeController
 * @Author Administrator
 * @Date 2019/2/14 10:52
 */
@Controller
@RequestMapping("/course/notice")
public class CourseNoticeController {

    @Resource
    private CourseService courseService;

    @Resource
    private NoticeTextService noticeTextService;

    @Resource
    private CourseNoticeService noticeService;

    /**
     * @Author liuhuan
     * @Description 课程通知公告
     * @Date 18:06 2019/2/15
     * @Param [noticeTitle, content, lessonId]
     * @return java.util.Map
     **/
    @ResponseBody
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    public Map addNotice(String noticeTitle, String content, Long lessonId){
        //所属课程
        Course course = courseService.findById(lessonId);
        //获取当前用户id (设置假数据为admin)
        // TODO: 2019/2/14
        Long userId = 1L;
        //获取新增的内容表的id
        Long noticeTextId = noticeTextService.addContent(content);
        //新增notice表
        return noticeService.addNotice(noticeTitle,noticeTextId,lessonId,userId);
    }

    /**
     * @Author liuhuan
     * @Description 展示该课程的所有公告
     * @Date 15:27 2019/2/21
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllCourseNotice")
    public Map getAllCourseNotice(Long courseId){
        return noticeService.selectAllNotice(courseId);
    }
}
