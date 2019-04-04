package com.zr.gansu.manage.controller;

import com.zr.gansu.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CourseController
 * @Author Administrator
 * @Date 2019/2/18 10:45
 */
@Controller
@Slf4j
@RequestMapping("/admin/course")
public class AdminCourseController {

    @Resource
    private CourseService courseService;
    /**
     * @Author liuhuan
     * @Description 获取当前教师所有发布课程列表
     * @Date 9:42 2019/2/18
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping("/getAllCourse")
    public Map getAllCourse(String teacherId, Integer page, Integer size){
        //获取所有课程的list
        return courseService.selectAllCourse(teacherId,page,size);
    }
}
