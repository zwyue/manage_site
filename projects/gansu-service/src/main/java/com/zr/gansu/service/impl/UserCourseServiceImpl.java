package com.zr.gansu.service.impl;

import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CourseMapper;
import com.zr.gansu.dao.UserCourseMapper;
import com.zr.gansu.domain.Course;
import com.zr.gansu.domain.UserCourse;
import com.zr.gansu.service.UserCourseService;
import com.zr.gansu.vo.UserCourseStudyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserCourseServiceImpl
 * @Author Administrator
 * @Date 2019/2/15 14:05
 */
@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Resource
    private UserCourseMapper userCourseMapper;

    @Resource
    private CourseMapper courseMapper;
    /**
     * @Author liuhuan
     * @Description 加入学习计划
     * @Date 14:07 2019/2/15
     * @Param [courseId, userId]
     * @return void
     **/
    @Override
    public Map adduserCourse(Long courseId, Long userId) {
        UserCourse userCourse = new UserCourse();
        //加入用户课程表
        userCourse.setAddTime(new Date());
        userCourse.setCourseId(courseId);
        userCourse.setUserId(userId);
        //加入即为学习中
        userCourse.setStatus(Constants.STUDY_STATUS_IN);
        userCourse.setGmtCreate(new Date());
        userCourseMapper.insert(userCourse);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 预览学习计划
     * @Date 17:30 2019/2/20
     * @Param [userId]
     * @return java.util.Map
     **/
    @Override
    public Map getAllStudyPlan(Long userId) {
        List<UserCourse> userCourses = userCourseMapper.selectByUserId(userId);
        UserCourseStudyVo userCourseStudyVo = new UserCourseStudyVo();
        List<UserCourseStudyVo> userCourseStudyVoList = new ArrayList<>();
        if (userCourses.size()!=0){
            for (int i= 0;i<userCourses.size();i++){
                Long courseId = userCourses.get(i).getCourseId();
                Course course = courseMapper.selectByPrimaryKey(courseId);
                userCourseStudyVo.setId(userCourses.get(i).getId());
                userCourseStudyVo.setCourseId(userCourses.get(i).getCourseId());
                userCourseStudyVo.setUserId(userCourses.get(i).getUserId());
                userCourseStudyVo.setPercent(userCourses.get(i).getPercent());
                userCourseStudyVo.setStatus(userCourses.get(i).getStatus());
                userCourseStudyVo.setAddTime(userCourses.get(i).getAddTime());
                userCourseStudyVo.setCourse(course);
                userCourseStudyVoList.add(i,userCourseStudyVo);
            }
            return ResultUtils.success(userCourseStudyVoList,ResultMsg.FIND_SUCCESS.msg());
        }else {
            return ResultUtils.success(ResultMsg.RESULE_DATA_NONE.msg());
        }
    }

    @Override
    public Integer selectPlanByCourseId(Long courseId,Long userId) {
        return userCourseMapper.queryByCourseId(courseId,userId);
    }

    /**
     * @Author liuhuan
     * @Description 退出学习计划
     * @Date 15:18 2019/2/21
     * @Param [courseId, userId]
     * @return java.util.Map
     **/
    @Override
    public Map endStudyPlan(Long courseId, Long userId) {
        UserCourse userCourse = userCourseMapper.selectByCourseIdAndUserId(courseId,userId);
        userCourse.setIsDeleted(Constants.IS_DELETED_YES);
        userCourseMapper.updateByPrimaryKey(userCourse);
        return ResultUtils.success(ResultMsg.END_STUDY_PALN.msg());
    }

}
