package com.zr.gansu.dao;

import com.zr.gansu.domain.BonusType;
import com.zr.gansu.vo.BonusTypeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@ClassName BonusTypeMapper
 *@Desciption 加分类型
 *@Author wanglidong
 *@Date 2019/2/25 9:57
 *@return
 */
@Repository
public interface BonusTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BonusType record);

    int insertSelective(BonusType record);

    int updateByPrimaryKeySelective(BonusType record);

    int queryBonusTypeByName(String typeName);

    List<BonusTypeVo> queryBonusType();

    BonusType queryBonusTypeById(Long id);

    BonusType selectBonusType(String typeName);
}
