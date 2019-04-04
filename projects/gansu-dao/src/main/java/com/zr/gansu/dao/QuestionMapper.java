package com.zr.gansu.dao;

import com.zr.gansu.domain.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMapper {

    int deleteByPrimaryKey(Long questionnaireId);

    int insert(Question record);

    Question selectQuAndOptions(Long id);

    int updateByPrimaryKeySelective(Question record);

    int updateIsDeleted(Long id);

}