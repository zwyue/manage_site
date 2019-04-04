package com.zr.gansu.web.controller;

import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 课程收藏控制器
 *
 * @author yuyi
 */

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;


    /**
     *  添加/取消 课程收藏
     *
     * @param type 操作类别 ：添加 join / 取消 cancel
     *
     * @param courseId 课程ID
     *
     * @author  yuyi
     */
    @PostMapping("/{type}/{courseId}")
    public Map collectionCourse(@PathVariable String type, @PathVariable Long courseId) {
        //todo  用户ID待定
        Long userId = 0L;
        if(Constants.Course.JOIN_COLLECTION.equalsIgnoreCase(type)) {
            return collectionService.joinCollection(userId,courseId);
        } else if(Constants.Course.CANCEL_COLLECTION.equalsIgnoreCase(type)) {
            return collectionService.cancelCollection(userId,courseId);
        } else {
            return ResultUtils.success(false,"非法提交");
        }
    }
}
