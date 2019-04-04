package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Goods;
import com.zr.gansu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * 积分商品控制类
 *
 * @author WG
 * @date 2019/2/20 11:30
 */
@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    final
    private GoodsService goodsService;

    @Autowired
    public AdminGoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 添加积分商品
     *
     * @author WG
     * @date 2019/2/20 11:36
     * @param goods 商品信息
     * @return 是否添加成功
     */
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Map addGoods(Goods goods) {
        if (ObjectUtil.isNotNull(goods)) {
            goods.setGmtCreate(new Date());
            goods.setGmtModified(new Date());
            if (goodsService.addGoods(goods) > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 查询商品分页List
     *
     * @author WG
     * @date 2019/2/20 17:08
     * @return 商品list
     */
    @RequestMapping("/list")
    public Map goodsList(Goods goods, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                         @RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
        if (ObjectUtil.isNotNull(goods)) {
            //分页参数，true代表统计count总数
            PageHelper.startPage(pageNum,pageSize,true);
            ResultUtils.success(goodsService.queryGoodsList(goods),ResultMsg.SUCCESS.msg()) ;
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 删除商品
     *
     * @author WG
     * @date 2019/2/20 17:37
     * @param goods 商品信息
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    public Map deleteGoods(Goods goods) {
        if ( ObjectUtil.isNotNull(goods) && goods.getId() != null) {
            //0:为删除状态,逻辑删除
            goods.setIsDeleted(0);
            if (goodsService.updateGoods(goods) > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.success(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 更新商品信息
     *
     * @author WG
     * @date 2019/2/20 17:41
     * @param goods 更新商品信息
     * @return 是否更新成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map updateGoods(Goods goods) {
        if (ObjectUtil.isNotNull(goods) && goods.getId() != null ){
            goods.setGmtModified(new Date());
            if (goodsService.updateGoods(goods) > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.success(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 查询商品详情
     *
     * @author WG
     * @date 2019/2/20 17:51
     * @param id 商品主键
     * @return 商品详情
     */
    @RequestMapping("/details")
    public Map queryGoodsDetails(Long id) {
        if (id != null ) {
            ResultUtils.success(goodsService.queryGoodsDetails(id),ResultMsg.SUCCESS.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

}
