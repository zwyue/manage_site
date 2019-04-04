package com.zr.gansu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CourseMapper;
import com.zr.gansu.dao.CoursePeriodMapper;
import com.zr.gansu.domain.Course;
import com.zr.gansu.domain.CoursePeriod;
import com.zr.gansu.form.CourseForm;
import com.zr.gansu.service.CourseService;
import com.zr.gansu.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WangGang
 * @description 课程的实现类
 * @date 2018/12/20
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    final
    private CourseMapper courseMapper;

    @Resource
    private CoursePeriodMapper coursePeriodMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /**
     * @description  获取课程分页信息实现方法
     * @author    Wg
     * @date     2018/12/20 11:34
     */
    @Override
    public List<Course> getCourseList(Course course) {
        Map<String,Object> paramMap = BeanUtil.beanToMap(course);
        return courseMapper.queryCourseList(paramMap);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<CourseVo> getRecommendCourses(Long tagId) {
        //统计数量
        Integer num = courseMapper.countByTagId(tagId);
        if(num.equals(0)) {
            tagId = null;
        }
        //默认获取五条记录
        PageHelper.startPage(1,5);
        List<CourseVo> list = courseMapper.findByTagId(tagId);
        return new PageInfo<>(list).getList();
    }
    /**
     * @Author liuhuan
     * @Description 通过课程ID查找对应课程
     * @Date 13:43 2019/2/14
     * @Param [courseId]
     * @return com.zr.gansu.domain.Course
     **/
    @Override
    public Course findById(Long lessonId) {

        return courseMapper.selectByPrimaryKey(lessonId);
    }

    /**
     * @Author liuhuan
     * @Description 更新课程信息
     * @Date 10:19 2019/2/15
     * @Param [course]
     * @return void
     **/
    @Override
    public void updateCourse(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    /**
     * @Author liuhuan
     * @Description 发布课程
     * @Date 15:51 2019/2/15
     * @Param [courseForm]
     * @return java.util.Map
     **/
    @Override
    public Map createCourse(CourseForm courseForm) {
        Course course = new Course();
        course.setTitle(courseForm.getTitle());
        course.setAuthorId(courseForm.getAuthorId());
        course.setGmtCreate(new Date());
        //发布为未审核
        course.setAuditStatus(Constants.AUDIT_STATUS_NO);
        course.setThumbnail(courseForm.getThumbnail());
        course.setTagId(courseForm.getTagId());
        course.setTypeId(courseForm.getTypeId());
        course.setDescription(courseForm.getDescription());
        //发布为发布中
        course.setStatus(Constants.COURSE_CREATE_STATUS);
        courseMapper.insert(course);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 查找该教师发布的所有课程列表
     * @Date 9:56 2019/2/18
     * @Param [teacherId]
     * @return java.util.List<com.zr.gansu.domain.Course>
     **/
    @Override
    public Map selectAllCourse(String teacherId, Integer page, Integer size) {
        //实现分页
        PageHelper.startPage(page,size);
        //通过老师（发布者）找到所有对应的课程
        List<Course> courseList = courseMapper.selectByAuthId(teacherId);
        PageInfo<Course> pageInfo = new PageInfo(courseList);
        return ResultUtils.success(pageInfo,ResultMsg.FIND_SUCCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 审核课程
     * @Date 11:29 2019/2/18
     * @Param [courseId]
     * @return java.util.Map
     **/
    @Override
    public Map auditCourse(Course course,Integer auditStatus,String auditOpinion) {
        //修改course中审核状态
        course.setAuditStatus(auditStatus);
        //添加审核意见
        course.setAuditOpinion(auditOpinion);
        courseMapper.updateByPrimaryKey(course);
        return ResultUtils.success(ResultMsg.AUDIT_SUCCESS);
    }

    /**
     * @Author liuhuan
     * @Description 删除课程
     * @Date 17:29 2019/2/18
     * @Param [courseId]
     * @return void
     **/
    @Override
    public Map deleteById(Long courseId) {
        //查找对应的课程
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if (course!=null){
            //查询课程对应的课时信息
            List<CoursePeriod> coursePeriodLists = coursePeriodMapper.selectByCourseId(courseId);
            if (coursePeriodLists.size()==0||coursePeriodLists==null){
                log.info("无对应课时");
            }else {
                //遍历获得查找的所有课时
                for (int i=0;i<coursePeriodLists.size();i++){
                    //删除对应的课时信息
                    coursePeriodLists.get(i).setIsDeleted(Constants.IS_DELETED_YES);
                    coursePeriodMapper.updateByPrimaryKey(coursePeriodLists.get(i));
                }
            }
            //更新课程删除记录
            course.setIsDeleted(Constants.IS_DELETED_YES);
            courseMapper.updateByPrimaryKey(course);
            return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
        }else {
            //无该课程
            return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
        }
    }


    @Override
    public boolean isExist(long courseId) {
        Course course = courseMapper.selectByPrimaryKey(courseId);
        if(ObjectUtil.isNotNull(course)){
            if(course.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                return true;
            }
        }
        return false;
    }
}
