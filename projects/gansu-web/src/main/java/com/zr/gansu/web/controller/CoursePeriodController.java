package com.zr.gansu.web.controller;

import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.form.CoursePeriodForm;
import com.zr.gansu.service.CoursePeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CoursePeriodController
 * @Author Administrator
 * @Date 2019/2/18 13:42
 */
@Controller
@Slf4j
@RequestMapping("/courseperiod")
public class CoursePeriodController {
    @Resource
    private CoursePeriodService coursePeriodService;

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
     * @Description 删除课时（可删除多个）
     * @Date 13:43 2019/2/18
     * @Param
     * @return
     **/
    @RequestMapping("/deleteCoursePeriod")
    public void deleteCoursePeriod(String courseperiodIds){
        //将传入的可是ID分隔
        String[] Ids = courseperiodIds.split(",");
        for (int i = 0;i<Ids.length;i++){
            String coursePeriodIdString = Ids[i];
            //转化为单个的ID
            Long coursePeriodId = Long.valueOf(coursePeriodIdString);
            coursePeriodService.deleteByIds(coursePeriodId);
        }
    }

}
