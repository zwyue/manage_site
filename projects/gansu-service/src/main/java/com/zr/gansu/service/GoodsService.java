package com.zr.gansu.service;

import com.zr.gansu.domain.Goods;

import java.util.List;

/**
 *  积分商品接口类
 *
 * @author WG
 * @date 2019/2/20 11:23
 */
public interface GoodsService {

    /**
     * 添加积分商品
     *
     * @author WG
     * @date 2019/2/20 11:26
     * @param goods 商品信息
     * @return 是否添加成功
     */
    int addGoods(Goods goods);

    /**
     * 查询商品List
     *
     * @author WG
     * @date 2019/2/20 17:19
     * @param goods 商品信息
     * @return 商品List
     */
    List queryGoodsList(Goods goods);

    /**
     * 更新商品信息
     *
     * @author WG
     * @date 2019/2/20 17:34
     * @param goods 商品信息
     * @return 是否更新成功
     */
    int updateGoods(Goods goods);

    /**
     * 查看商品详细
     *
     * @author WG
     * @date 2019/2/20 17:50
     * @param id 商品主键id
     * @return 商品详细
     */
    Goods queryGoodsDetails(Long id);
}
