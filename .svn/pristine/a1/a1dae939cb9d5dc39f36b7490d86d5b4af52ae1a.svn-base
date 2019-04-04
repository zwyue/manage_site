package com.zr.gansu.dao;

import com.zr.gansu.domain.News;
import com.zr.gansu.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    List<Tag> getTagList();

}