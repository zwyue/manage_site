package com.zr.gansu.service.impl;

import com.zr.gansu.dao.GoodsMapper;
import com.zr.gansu.domain.Goods;
import com.zr.gansu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 积分商品接口实现类
 *
 * @author WG
 * @date 2019/2/20 11:24
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    final
    private GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public List queryGoodsList(Goods goods) {
        return goodsMapper.queryGoodsList(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public Goods queryGoodsDetails(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
