package com.zr.gansu.service.impl;

import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CollectionTagRealtionshipMapper;
import com.zr.gansu.domain.CollectionTagRealtionship;
import com.zr.gansu.service.CollectionTagRealtionShipSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName CourseCollectionTagServiceImpl
 * @Author Administrator
 * @Date 2019/2/21 9:49
 */
@Slf4j
@Service
public class CollectionTagRealtionShipServiceImpl implements CollectionTagRealtionShipSevice {
    @Resource
    private CollectionTagRealtionshipMapper collectionTagRealtionshipMapper;

    /**
     * @Author liuhuan
     * @Description 插入标签关系表
     * @Date 13:48 2019/2/21
     * @Param [collectionTagRealtionship]
     * @return java.util.Map
     **/
    @Override
    public Map insert(CollectionTagRealtionship collectionTagRealtionship) {
        collectionTagRealtionshipMapper.insert(collectionTagRealtionship);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }
}
