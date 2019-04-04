package com.zr.gansu.service.impl;

import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CoursePeriodMapper;
import com.zr.gansu.domain.CoursePeriod;
import com.zr.gansu.form.CoursePeriodForm;
import com.zr.gansu.service.CoursePeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName CoursePeriodServiceImpl
 * @Author Administrator
 * @Date 2019/2/15 17:10
 */
@Service
@Slf4j
public class CoursePeriodServiceImpl implements CoursePeriodService {
    @Resource
    private CoursePeriodMapper coursePeriodMapper;

    /**
     * @Author liuhuan
     * @Description 新增课时
     * @Date 17:48 2019/2/15
     * @Param [coursePeriodForm]
     * @return java.util.Map
     **/
    @Override
    public Map createCoursePeriod(CoursePeriodForm coursePeriodForm) {
        CoursePeriod coursePeriod = new CoursePeriod();
        coursePeriod.setCourseId(coursePeriodForm.getCourseId());
        coursePeriod.setGmtCreate(new Date());
        coursePeriod.setSort(coursePeriodForm.getSort());
        coursePeriod.setTime(coursePeriodForm.getTime());
        coursePeriod.setTitle(coursePeriodForm.getTitle());
        coursePeriod.setUrl(coursePeriodForm.getUrl());
        coursePeriodMapper.insert(coursePeriod);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 删除课时
     * @Date 14:21 2019/2/18
     * @Param [coursePeriod]
     * @return java.util.Map
     **/

    @Override
    public Map deleteByIds(Long coursePeriodId) {
        log.info("正在删除id为{}的课时",coursePeriodId);
        CoursePeriod coursePeriod = coursePeriodMapper.selectByPrimaryKey(coursePeriodId);
        if (coursePeriod != null){
            //数据库存在该课时
            coursePeriod.setIsDeleted(Constants.IS_DELETED_YES);
            coursePeriodMapper.updateByPrimaryKey(coursePeriod);
            return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
        }else {
            return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
        }
    }

    /**
     * @Author liuhuan
     * @Description 编辑课时
     * @Date 17:24 2019/2/19
     * @Param [coursePeriod]
     * @return java.util.Map
     **/

    @Override
    public Map updatePeriod(CoursePeriod coursePeriod) {
        CoursePeriod coursePeriod1 = coursePeriodMapper.selectByPrimaryKey(coursePeriod.getId());
        if (coursePeriod1 == null) {
            //无对应的课时信息
            return ResultUtils.error(ResultMsg.RESULE_DATA_NONE.msg());
        }else {
            log.info("正在编辑的课时为{}",coursePeriod1.getId());
            if (coursePeriod1.getIsDeleted().equals(Constants.IS_DELETED_YES)){
                //该课时已被删除
                return ResultUtils.error(ResultMsg.DATA_IS_DELETED);
            }else {
                coursePeriodMapper.updateByPrimaryKey(coursePeriod);
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
        }
    }
}
