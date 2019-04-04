package com.zr.gansu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Course;
import com.zr.gansu.domain.CoursePeriod;
import com.zr.gansu.domain.*;
import com.zr.gansu.form.CourseForm;
import com.zr.gansu.form.CoursePeriodForm;
import com.zr.gansu.service.*;
import com.zr.gansu.vo.CourseVo;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author WangGang
 * @description 课程控制类
 * @date 2018/12/20
 */
@Controller
@Slf4j
@RequestMapping("/member/course")
public class CourseController {

    private final
    CourseService courseService;

    @Resource
    private UserCourseService userCourseService;

    @Resource
    private CollectionService collectionService;

    @Resource
    private CoursePeriodService coursePeriodService;

    @Resource
    private CollectionTagService collectionTagService;

    @Resource
    private CollectionTagRealtionShipSevice collectionTagRealtionShipSevice;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * @Author liuhuan
     * @Description 发布课程
     * @Date 13:33 2019/2/15
     * @Param
     * @return
     **/
    @RequestMapping("/createCourse")
    public Map createCourse(CourseForm courseForm){
        //获取当前用户id
        // TODO: 2019/2/15
        String teacherId = "0";
        courseForm.setAuthorId(teacherId);
        return courseService.createCourse(courseForm);
    }

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
    /**
     * @Author liuhuan
     * @Description 发布教师删除发布课程（可删除多个）
     * @Date 13:38 2019/2/18
     * @Param
     * @return
     **/
    @RequestMapping("/deleteCourses")
    public void deleteCourses(String courseIds){
        //分隔传入的字符串
        String[] Ids = courseIds.split(",");
        for (int i=0;i<Ids.length;i++){
            Long courseId = Long.valueOf(Ids[i]);
            courseService.deleteById(courseId);
        }
    }
    /**
     * @Author liuhuan
     * @Description 创建课时
     * @Date 16:22 2019/2/15
     * @Param [courseId]
     * @return boolean
     **/
    @RequestMapping("/createCoursePeriod")
    public Map createCoursePeriod(CoursePeriodForm coursePeriodForm){
        return coursePeriodService.createCoursePeriod(coursePeriodForm);
    }

    /**
     * @Author liuhuan
     * @Description 编辑课时
     * @Date 17:05 2019/2/19
     * @Param
     * @return
     **/
    @RequestMapping("/updateCoursePeriod")
    public Map updateCoursePeriod(CoursePeriod coursePeriod){
        return coursePeriodService.updatePeriod(coursePeriod);
    }

    /**
     * @description  获取课程列表
     * @author    Wg
     * @date     2018/12/20 10:53
     * @return 返回课程列表
     */
    @ResponseBody
    @RequestMapping("/ajaxcourselist")
    public PageInfo queryCourse(Course course, Integer pageNum, Integer pageSize) {
        //分页参数，true代表统计count总数
        PageHelper.startPage(pageNum,pageSize,true);
        //获取课程列表
        List<Course> list = courseService.getCourseList(course);
        return new PageInfo<>(list);
    }

    /**
     * @Author liuhuan
     * @Description 点击查看课程
     * @Date 10:00 2019/2/15
     * @Param
     * @return
     **/
    @RequestMapping("/opencourse")
    public void opencourse(Long courseId){
        //找到相应的课程id
        Course course = courseService.findById(courseId);
        //浏览量增加1
        Long viewCount = course.getViewCount();
        course.setViewCount(viewCount + 1);
        courseService.updateCourse(course);
        log.info("更新完成");
    }

/*
    */
/**
     * @Author liuhuan
     * @Description 将课程加入收藏
     * @Date 10:25 2019/2/15
     * @Param
     * @return
     **//*

    @RequestMapping("/collectioncourse")
    public Map collectioncourse(Long courseId){
        //获取当前用户ID
        // TODO: 2019/2/15
        Long userId = 0L;
        //找到对应课程
        Course course = courseService.findById(courseId);
        CollectionDomain collectionDomain = collectionService.selectByCourseIdAndUserId(courseId,userId);
        if (collectionDomain==null){
            return ResultUtils.error(ResultMsg.DATA_ALREADY_EXISTED.msg());
        }
        Long collectionCount = course.getCollectionCount();
        //课程收藏数+1
        course.setCollectionCount(collectionCount + 1);
        courseService.updateCourse(course);
        log.info("更新完成");
        //插入用户收藏表
        return collectionService.addCollection(courseId,userId);
    }
*/

    /**
     * @Author liuhuan
     * @Description 对收藏课程添加标签
     * @Date 15:53 2019/2/20
     * @Param
     * @return
     **/
    @RequestMapping(value = "/addcollectionCourseTag")
    public Map addcollectionCourseTag(String tagIds,String tagNames,Long collectionId){
        //获取当前用户ID
        // TODO: 2019/2/15
        Long userId = 0L;
        //传入标签
        //将传入的多个标签ID分隔
        String[] tagId = tagIds.split(",");
        //分隔传入的标签名
        String[] tagname = tagNames.split(",");
        CollectionTag collectionTag;
        CollectionTagRealtionship collectionTagRealtionship = new CollectionTagRealtionship();
        for (int i=0;i<tagId.length;i++){
            //查找对应的的课程标签
            collectionTag = collectionTagService.selectById(tagId[i]);
            if (collectionTag == null){
                //课程标签不存在，重新创建新标签
                String collectionTagname = tagname[i];
                collectionTag.setUserId(userId);
                collectionTag.setTagName(collectionTagname);
                collectionTag.setGmtCreate(new Date());
                collectionTagService.insert(collectionTag);
                Long collectionTagRealtionshipId = collectionTag.getId();
                collectionTagRealtionship.setTagId(collectionTagRealtionshipId);
            }else {
                Long collectionTagRealtionshipId = Long.valueOf(tagId[i]);
                collectionTagRealtionship.setTagId(collectionTagRealtionshipId);
            }
            //存入标签收藏关系表
            collectionTagRealtionship.setUserId(userId);
            collectionTagRealtionship.setCollectionId(collectionId);
            collectionTagRealtionShipSevice.insert(collectionTagRealtionship);
        }
        return ResultUtils.success(ResultMsg.COLLECTION_TAG_SUCCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 新建收藏标签
     * @Date 11:23 2019/2/21
     * @Param
     * @return
     **/
    @RequestMapping(value = "/createTag",method = RequestMethod.POST)
    public Map createTag(String tagname){
        //获取当前用户ID
        // TODO: 2019/2/21
        Long userId = 0L;
        CollectionTag collectionTag = new CollectionTag();
        collectionTag.setUserId(userId);
        collectionTag.setTagName(tagname);
        collectionTag.setGmtCreate(new Date());
        return collectionTagService.insert(collectionTag);
    }

    /**
     * @Author liuhuan
     * @Description 获取该用户所有标签
     * @Date 9:54 2019/2/21
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllTag")
    public Map getAllTag(){
        //获取当前用户ID
        // TODO: 2019/2/15
        Long userId = 0L;
        return collectionTagService.selectAllTagByUser(userId);
    }

    /**
     * @Author liuhuan
     * @Description 浏览加入收藏的所有课程
     * @Date 16:08 2019/2/20
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllcourseCollectioned")
    public Map getAllcourseCollectioned(){
        //获取当前用户ID
        // TODO: 2019/2/15
        Long userId = 0L;
        log.info("进入用户{}的收藏预览",userId);
        //查找对应的用户的所有收藏
        return collectionService.selectAllCollect(userId);
    }


    /**
     * @Author liuhuan
     * @Description 加入(退出，结束)学习计划
     * @Date 10:26 2019/2/15
     * @Param 前端传入status，0为加入，1为退出结束
     * @return
     **/
    @RequestMapping(value = "/courseplan")
    public Map courseplan(Long courseId,Integer status){
        //获取当前用户ID
        // TODO: 2019/2/15 获取当前用户
        Long userId = 1L;
        Course course = courseService.findById(courseId);
        Long courseplancount = course.getAddStudyCount();
        //查重
        Integer studyPlanNum = userCourseService.selectPlanByCourseId(courseId,userId);
        if (status.equals(Constants.STUDY_STATUS_IN)) {
            if (studyPlanNum!=0){
                //数据库存在该课程的学习计划
                return ResultUtils.error(ResultMsg.DATA_ALREADY_EXISTED.msg());
            }
            //加入学习计划
            //课程学习计划人数+1
            course.setAddStudyCount(courseplancount + 1);
            courseService.updateCourse(course);
            log.info("更新完成");
            //插入用户学习课程表
            return userCourseService.adduserCourse(courseId, userId);
        }else if (status.equals(Constants.STUDY_STATUS_OUT)){
            //退出学习计划
            if (studyPlanNum==0){
                //无此学习计划
                return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
            }
            //退出，结束学习计划
            course.setAddStudyCount(courseplancount - 1);
            courseService.updateCourse(course);
            log.info("更新完成");
            return userCourseService.endStudyPlan(courseId,userId);

        }else {
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
    }


    /**
     * @Author liuhuan
     * @Description 查看所有的学习计划
     * @Date 17:27 2019/2/20
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping("/getAllStudyPlan")
    public Map getAllStudyPlan(){
        //获取当前用户ID
        // TODO: 2019/2/15 获取当前用户
        Long userId = 1L;
        log.info("进入用户{}的学习计划预览",userId);
        return userCourseService.getAllStudyPlan(userId);
    }

    /**
     * @Author liuhuan
     * @Description 资源统计/使用率/点击数/加入学习数/加入收藏数
     * @Date 10:35 2019/2/15
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping("/resourcescount")
    public Map resourcesconunt(Long courseId){
        Course course = courseService.findById(courseId);
        //计算资源使用率
        Long uselevel = course.getAddStudyCount()/course.getViewCount();
        //资源被收藏数
        Long collectioncount = course.getCollectionCount();
        //资源加入学习计划数
        Long addstudycount = course.getAddStudyCount();
        List<Long> resourcescount = new ArrayList<>();
        resourcescount.add(1,uselevel);
        resourcescount.add(2,collectioncount);
        resourcescount.add(3,addstudycount);
        return ResultUtils.success(resourcescount);
    }

    /**
     * 获取推荐课程列表 5条记录
     *
     * @author yuyi
     *
     * @param tagId 标签ID
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list/recommend/{tagId}", method = RequestMethod.GET)
    public Map recommendCourse(@PathVariable Long tagId) {
        List<CourseVo> courseVoList = courseService.getRecommendCourses(tagId);
        return ResultUtils.success(courseVoList);
    }
}
