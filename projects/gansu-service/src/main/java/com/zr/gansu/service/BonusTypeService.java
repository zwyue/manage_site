package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.BonusType;

/**
 * @Author
 * @Description  加分类型
 * @Date
 * @Param [userOrder]userId, orderId, apply_man.apply_woman
 * apply_startdate,apply_enddate
 * @return void
 **/
public interface BonusTypeService {

    /**
     * 添加加分类型
     * @param typeName
     * @param scores
     * @return
     */
    Integer addBonusType(String typeName,Long scores);

    /**
     * 修改内容
     * @param id
     * @param typeName
     * @param scores
     * @return
     */
    Integer modifyBonusType(Long id,String typeName,Long scores);

    /**
     * 查询加分分类
     * @param pageNum
     * @param pageSize
     * @return
     */

    PageInfo queryBonusType(Integer pageNum,Integer pageSize);

    BonusType queryBonusTypeById(Long id);

    Integer delBonusTypeById(Long id);
}
