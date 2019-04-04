package com.zr.gansu.service;

import com.zr.gansu.domain.CoursePeriod;
import com.zr.gansu.form.CoursePeriodForm;

import java.util.Map;

/**
 * @ClassName CoursePeriodService
 * @Author Administrator
 * @Date 2019/2/15 17:09
 */
public interface CoursePeriodService {

    /**
     * 新建课时
     **/
    Map createCoursePeriod(CoursePeriodForm coursePeriodForm);
    /**
     * 删除课时
     **/
    Map deleteByIds(Long coursePeriodId);

    /**
     * 编辑课时
     **/
    Map updatePeriod(CoursePeriod coursePeriod);
}
