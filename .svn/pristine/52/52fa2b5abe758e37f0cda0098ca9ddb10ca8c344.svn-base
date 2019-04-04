package com.zr.gansu.dao;

import com.zr.gansu.domain.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询该分类下，有没有被使用
     *
     * @author WG
     * @date 2019/2/20 16:03
     * @param catagoryId 商品所属分类id
     * @return 存在数量
     */
    int classificationUsing(Long catagoryId);

    /**
     * 查询商品List
     *
     * @author WG
     * @date 2019/2/20 17:21
     * @param goods 商品信息
     * @return 商品List
     */
    List queryGoodsList(Goods goods);
}