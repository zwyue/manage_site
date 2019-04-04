package com.zr.gansu.service.impl;

import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CollectionDomainMapper;
import com.zr.gansu.dao.CollectionTagMapper;
import com.zr.gansu.dao.CollectionTagRealtionshipMapper;
import com.zr.gansu.dao.CourseMapper;
import com.zr.gansu.domain.CollectionDomain;
import com.zr.gansu.domain.CollectionTag;
import com.zr.gansu.domain.CollectionTagRealtionship;
import com.zr.gansu.domain.Course;
import com.zr.gansu.service.CollectionService;
import com.zr.gansu.vo.CollectionCourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 课程收藏实现
 *
 * @author yuyi
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionDomainMapper collectionDomainMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CollectionTagMapper collectionTagMapper;

    @Resource
    private CollectionTagRealtionshipMapper collectionTagRealtionshipMapper;

    @Override
    public Map joinCollection(Long userId, Long courseId) {
        //先查后加
        CollectionDomain collectionDomain = collectionDomainMapper.findByUserIdAndCourseId(userId,courseId);
        if(collectionDomain != null) {
            if(!Constants.Course.COLLECTION_STATUS_JOIN.equals(collectionDomain.getStatus())){
                updateCollection(collectionDomain.getId(),Constants.Course.COLLECTION_STATUS_JOIN);
                //更新收藏数量
                updateCourseCollectionNumber(courseId,Constants.Course.COLLECTION_STATUS_JOIN);
            }
            return ResultUtils.success(true,"收藏成功");
        } else {
            CollectionDomain newData = new CollectionDomain();
            newData.setUserId(userId);
            newData.setCourseId(courseId);
            newData.setCollectionTime(new Date());
            newData.setStatus(Constants.Course.COLLECTION_STATUS_JOIN);
            newData.setGmtCreate(new Date());
            newData.setGmtModified(new Date());
            collectionDomainMapper.insertSelective(newData);
            //更新数量
            updateCourseCollectionNumber(courseId,Constants.Course.COLLECTION_STATUS_JOIN);
            return ResultUtils.success(true,"收藏成功");
        }
    }

    @Override
    public Map cancelCollection(Long userId, Long courseId) {
        //先查后加
        CollectionDomain collectionDomain = collectionDomainMapper.findByUserIdAndCourseId(userId,courseId);
        if(collectionDomain != null) {
            Integer status = collectionDomain.getStatus();
            if(!Constants.Course.COLLECTION_STATUS_CANCEL.equals(status)) {
                updateCollection(collectionDomain.getId(),Constants.Course.COLLECTION_STATUS_CANCEL);
                //更新数量
                updateCourseCollectionNumber(courseId,Constants.Course.COLLECTION_STATUS_CANCEL);
            }
            return ResultUtils.success(true,"取消成功");
        } else {
            return ResultUtils.success(false,"尚未收藏该课程");
        }
    }

    /**
     * @Author liuhuan
     * @Description 加入收藏
     * @Date 14:14 2019/2/15
     * @Param [courseId, userId]
     * @return java.util.Map
     **/
    @Override
    public Map addCollection(Long courseId, Long userId) {
        CollectionDomain collectionDomain = new CollectionDomain();
        collectionDomain.setCourseId(courseId);
        collectionDomain.setUserId(userId);
        collectionDomain.setCollectionTime(new Date());
        collectionDomainMapper.insert(collectionDomain);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 查看所有的收藏
     * @Date 16:11 2019/2/20
     * @Param [userId]
     * @return java.util.List<java.util.Collection>
     **/

    @Override
    public Map selectAllCollect(Long userId) {
        List<CollectionDomain> collectionList = collectionDomainMapper.selectByUserId(userId);
        CollectionCourseVo collectionCourseVo = new CollectionCourseVo();
        List<CollectionCourseVo> collectionCourseVoList = new ArrayList<>();
        if(collectionList.size()==0){
            return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
        }else {
            for (int i = 0;i<collectionList.size();i++){
                Long courseId = collectionList.get(i).getCourseId();
                //获取收藏的课程的信息
                Course course = courseMapper.selectByPrimaryKey(courseId);
                //获取收藏是否有标签
                Long collectionId = collectionList.get(i).getId();
                //获取该收藏的所有标签
                List<CollectionTagRealtionship> collectionTagRealtionships =
                        collectionTagRealtionshipMapper.selectByUserIdAndCollectionId(userId,collectionId);
                List<String> tagNames = new ArrayList<>();
                for (int j= 0;j<collectionTagRealtionships.size();j++){
                    CollectionTag collectionTag = collectionTagMapper
                            .selectByPrimaryKey(collectionTagRealtionships.get(j).getTagId());
                    //将获取的标签名保存
                    tagNames.add(j,collectionTag.getTagName());
                }
                collectionCourseVo.setTagname(tagNames);
                collectionCourseVo.setCourse(course);
                collectionCourseVo.setId(collectionList.get(i).getId());
                collectionCourseVo.setCourseId(collectionList.get(i).getCourseId());
                collectionCourseVo.setCollectionTime(collectionList.get(i).getCollectionTime());
                collectionCourseVo.setStatus(collectionList.get(i).getStatus());
                collectionCourseVo.setUserId(collectionList.get(i).getUserId());
                collectionCourseVoList.add(i,collectionCourseVo);
            }
            return ResultUtils.success(collectionCourseVoList,ResultMsg.FIND_SUCCESS.msg());
        }
    }

    /**
     * @Author liuhuan
     * @Description
     * @Date 18:13 2019/2/20
     * @Param [courseId, userId]
     * @return java.lang.Integer
     **/

    @Override
    public CollectionDomain selectByCourseIdAndUserId(Long courseId, Long userId) {
        return collectionDomainMapper.findByUserIdAndCourseId(userId,courseId);
    }

    /**
     * 根据状态更新
     *
     * @author yuyi
     *
     * @param id 收藏表主键
     *
     * @param status 收藏状态
     *
     */
    private void updateCollection(Long id, Integer status) {
        CollectionDomain updateData = new CollectionDomain();
        updateData.setCollectionTime(new Date());
        updateData.setId(id);
        updateData.setStatus(status);
        updateData.setGmtModified(new Date());
        collectionDomainMapper.updateByPrimaryKeySelective(updateData);
    }

    /**
     * 根据收藏状态更新课程的收藏数量
     *
     * @param courseId 课程ID
     *
     * @param status 收藏状态
     */
    private void updateCourseCollectionNumber(Long courseId, Integer status) {
        //查询课程
        Course courseDB = courseMapper.selectByPrimaryKey(courseId);
        Course course = new Course();
        course.setId(courseId);
        if(Constants.Course.COLLECTION_STATUS_JOIN.equals(status)) {
            course.setCollectionCount(courseDB.getCollectionCount() + 1);
        } else if(Constants.Course.COLLECTION_STATUS_CANCEL.equals(status)) {
            course.setCollectionCount(courseDB.getCollectionCount() - 1);
        }
        //更新课程收藏数量
        courseMapper.updateByPrimaryKeySelective(course);
    }

}
