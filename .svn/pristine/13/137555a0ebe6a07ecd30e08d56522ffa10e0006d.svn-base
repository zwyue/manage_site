package com.zr.gansu.service.impl;

import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CollectionTagMapper;
import com.zr.gansu.domain.CollectionTag;
import com.zr.gansu.service.CollectionTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CollectionTagServiceImpl
 * @Author Administrator
 * @Date 2019/2/20 15:59
 */
@Service
@Slf4j
public class CollectionTagServiceImpl implements CollectionTagService {
    @Resource
    private CollectionTagMapper collectionTagMapper;

    /**
     * @Author liuhuan
     * @Description 通过ID查找对应的标签内容
     * @Date 11:32 2019/2/21
     * @Param [s]
     * @return com.zr.gansu.domain.CollectionTag
     **/
    @Override
    public CollectionTag selectById(String s) {
        Long tagId = Long.valueOf(s);
        return collectionTagMapper.selectByPrimaryKey(tagId);
    }

    /**
     * @Author liuhuan
     * @Description 新增标签内容
     * @Date 11:32 2019/2/21
     * @Param [collectionTag]
     * @return java.util.Map
     **/
    @Override
    public Map insert(CollectionTag collectionTag) {
        collectionTagMapper.insert(collectionTag);
        return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
    }

    /**
     * @Author liuhuan
     * @Description 通过用户查找所有标签
     * @Date 11:37 2019/2/21
     * @Param [userId]
     * @return java.util.Map
     **/
    @Override
    public Map selectAllTagByUser(Long userId) {
        List<CollectionTag> collectionTagList = collectionTagMapper.selectAllTagByUser(userId);
        return ResultUtils.success(collectionTagList,ResultMsg.FIND_SUCCESS.msg());
    }
}
