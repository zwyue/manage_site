package com.zr.gansu.service.impl;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.dao.BonusTypeMapper;
import com.zr.gansu.domain.BonusType;
import com.zr.gansu.service.BonusTypeService;
import com.zr.gansu.vo.BonusTypeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName BonusTypeServiceImpl
 *@Desciption 加分类型
 *@Author wanglidong
 *@Date 2019/2/25 10:44
 *@return
 */
@Service
public class BonusTypeServiceImpl implements BonusTypeService {

    @Resource
    private BonusTypeMapper bonusTypeMapper;

    @Override
    public Integer addBonusType(String typeName, Long scores) {
        //根据类型名判断是否存在
        Integer counts = bonusTypeMapper.queryBonusTypeByName(typeName);
        if(counts.equals(Constants.EXECUTE_FAIL)){
            //不存在
            Date time=new Date(System.currentTimeMillis());
            BonusType bonusType=new BonusType();
            bonusType.setTypeName(typeName);
            bonusType.setScores(scores);
            bonusType.setGmtCreate(time);
            bonusType.setGmtModified(time);
            return bonusTypeMapper.insertSelective(bonusType);
        }else{
            //已存在
            return 2;
        }
    }

    @Override
    public Integer modifyBonusType(Long id, String typeName, Long scores) {

            //查询是否已经存在
            BonusType bonusType = bonusTypeMapper.queryBonusTypeById(id);
            if(ObjectUtil.isNotNull(bonusType)){
                BonusType bonus=new BonusType();
                bonus.setId(id);
                bonus.setScores(scores);
                bonus.setGmtModified(new Date(System.currentTimeMillis()));
                if(ObjectUtil.isNotNull(typeName)){
                    BonusType bonusType1 = bonusTypeMapper.selectBonusType(typeName);
                    if(ObjectUtil.isNotNull(bonusType1)){
                        if(bonusType1.getId().equals(bonusType.getId())){
                        }else{
                            return 2;
                        }
                    }else{
                        bonus.setTypeName(typeName);
                    }
                }
                //保存
                return bonusTypeMapper.updateByPrimaryKeySelective(bonus);
            }else{
                return 0;
            }
    }

    @Override
    public PageInfo queryBonusType(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BonusTypeVo> bonusTypeVos = bonusTypeMapper.queryBonusType();
        PageInfo pageInfo=new PageInfo(bonusTypeVos);
        return pageInfo;
    }

    @Override
    public BonusType queryBonusTypeById(Long id) {

       return bonusTypeMapper.queryBonusTypeById(id);
    }

    @Override
    public Integer delBonusTypeById(Long id) {
        BonusType bonusType = bonusTypeMapper.queryBonusTypeById(id);
        if(ObjectUtil.isNotNull(bonusType)){
            bonusType.setIsDeleted(Constants.IS_DELETED_YES);
            return bonusTypeMapper.updateByPrimaryKeySelective(bonusType);
        }
        return 0;
    }
}
