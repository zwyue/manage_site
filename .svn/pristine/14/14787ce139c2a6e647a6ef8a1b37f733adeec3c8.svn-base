package com.zr.gansu.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.CreditRecordMapper;
import com.zr.gansu.dao.GoodsMapper;
import com.zr.gansu.dao.UserMapper;
import com.zr.gansu.domain.CreditRecord;
import com.zr.gansu.domain.Goods;
import com.zr.gansu.domain.User;
import com.zr.gansu.service.CreditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 积分记录接口实现类
 *
 * @author WG
 * @date 2019/2/21 9:26
 */
@Service
public class CreditRecordServiceImpl implements CreditRecordService {


    final
    private CreditRecordMapper creditRecordMapper;

    final
    private UserMapper userMapper;

    final
    private GoodsMapper goodsMapper;

    @Autowired
    public CreditRecordServiceImpl(CreditRecordMapper creditRecordMapper, UserMapper userMapper, GoodsMapper goodsMapper) {
        this.creditRecordMapper = creditRecordMapper;
        this.userMapper = userMapper;
        this.goodsMapper = goodsMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map forGoods(Long userId, Long goodsId) {
        //根据用户id和商品id查询用户积分和商品信息
        User user = userMapper.queryByPrimaryKey(userId);
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (ObjectUtil.isNotNull(user) && ObjectUtil.isNotNull(goods)) {
            //库存判断
            if (goods.getStock() > 0) {
                //判断用户积分是否或者等于大于商品积分
                int num = user.getCredit() - goods.getPrice();
                if (num >= 0 ) {
                    CreditRecord creditRecord = new CreditRecord();
                    creditRecord.setUserId(userId);
                    creditRecord.setGoodsId(goodsId);
                    //类型2，为兑换商品
                    creditRecord.setType(2);
                    //变化后学分
                    creditRecord.setNowCredit(num);
                    //变化分数
                    creditRecord.setChangeCount(goods.getPrice());
                    creditRecord.setGmtCreate(new Date());
                    creditRecord.setGmtModified(new Date());
                    //判断插入学分记录表是否，成功
                    if ( creditRecordMapper.insertSelective(creditRecord) > 0) {
                        //更新用户表，用户学分
                        user.setCredit(num);
                        //判断更新user表学分，是否成功
                        if (userMapper.updateByPrimaryKeySelective(user) <= 0) {
                            return ResultUtils.error(ResultMsg.FAILED.msg());
                        }
                        //库存减一
                        goods.setStock(goods.getStock() - 1);
                        //更新商品库存
                        if (goodsMapper.updateByPrimaryKeySelective(goods) > 0) {
                            return ResultUtils.success(ResultMsg.SUCCESS.msg());
                        }
                        return ResultUtils.error(ResultMsg.FAILED.msg());
                    }
                    return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
                }
                return ResultUtils.error(ResultMsg.YOUR_POINTS_ARE_NOT_ENOUGH.msg());
            }
            return ResultUtils.error(ResultMsg.INVENTORY_SHORTAGE.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    @Override
    public List statisticsGoods() {
        return creditRecordMapper.statisticsGoods();
    }
}
