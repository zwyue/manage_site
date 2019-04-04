package com.zr.gansu.service.impl;

import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CatagoryMapper;
import com.zr.gansu.dao.GoodsMapper;
import com.zr.gansu.domain.Catagory;
import com.zr.gansu.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品分类接口实现类
 *
 * @author WG
 * @date 2019/2/20 13:34
 */
@Service
public class CatagoryServiceImpl implements CatagoryService {

    final
    private GoodsMapper goodsMapper;

    final
    private CatagoryMapper catagoryMapper;

    @Autowired
    public CatagoryServiceImpl(CatagoryMapper catagoryMapper, GoodsMapper goodsMapper) {
        this.catagoryMapper = catagoryMapper;
        this.goodsMapper = goodsMapper;
    }

    @Override
    public Map addCatagory(Catagory catagory) {
        if (catagoryMapper.queryCatagoryExist(catagory.getName()) < 1 ) {
            if (catagoryMapper.insertSelective(catagory) > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.THE_CATEGORY_ALREADY_EXISTS.msg());
    }

    @Override
    public List catagoryList() {
        return catagoryMapper.queryCatagoryList();
    }

    @Override
    public Map deleteCatagory(Long id) {
        //删除分类之前，先查看有没有使用该分类的商品，已经有使用的，就不能被删除
        if (goodsMapper.classificationUsing(id) < 1) {
           if (catagoryMapper.deleteByPrimaryKey(id) > 0) {
               return ResultUtils.success(ResultMsg.SUCCESS.msg());
           }
           return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.THIS_CLASSIFICATION_HAS_BEEN_USED_BY_COMMODITIES.msg());
    }

    @Override
    public Map updateCatagory(Catagory catagory) {
        //更新分类信息的时候，先检查分类名称是否存在
        if (catagoryMapper.queryCatagoryExist(catagory.getName()) < 1 ) {
            if (catagoryMapper.updateByPrimaryKeySelective(catagory) > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.THE_CATEGORY_ALREADY_EXISTS.msg());
    }
}
