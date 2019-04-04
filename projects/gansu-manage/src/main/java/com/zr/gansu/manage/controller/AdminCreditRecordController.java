package com.zr.gansu.manage.controller;

import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.CreditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 积分记录控制类
 *
 * @author WG
 * @date 2019/2/21 9:21
 */
@RestController
@RequestMapping("/admin/credit")
public class AdminCreditRecordController {

    final
    private CreditRecordService creditRecordService;

    @Autowired
    public AdminCreditRecordController(CreditRecordService creditRecordService) {
        this.creditRecordService = creditRecordService;
    }

    /**
     * 积分兑换商品
     *
     * @author WG
     * @date 2019/2/21 9:46
     * @param userId 用户id goodsId 商品id
     * @return 是否兑换成功
     */
    @RequestMapping("/for/goods")
    public Map forGoods(Long userId, Long goodsId) {
        if (userId != null && goodsId != null) {
            return creditRecordService.forGoods(userId, goodsId);
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     *  统计商品兑换
     *
     * @author WG
     * @date 2019/2/26 10:03
     */
    @RequestMapping("/statistic")
    public Map statisticsGoods() {
        return ResultUtils.success(creditRecordService.statisticsGoods());
    }
}
