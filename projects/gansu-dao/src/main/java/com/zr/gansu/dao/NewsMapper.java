package com.zr.gansu.dao;

import com.zr.gansu.domain.News;
import com.zr.gansu.domain.vo.NewsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    /**
     * 新增新闻信息
     * @param newsVo 新闻信息
     * @return 影响的行数
     */
    int insertSelective(NewsVo newsVo);

    /**
     * 查询新闻详情 后台展示
     * @param id 新闻id
     * @return 新闻信息
     */
    News selectByPrimaryKey(Long id);

    /**
     * 修改新闻信息
     * @param newsVo 新闻信息
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(NewsVo newsVo);

    /**
     * 删除新闻 逻辑删除
     * @param id 新闻id
     * @return  int
     */
    int deleteNewsById(Long id);

    /**
     * 查询新闻列表 前台首页展示
     * @param siteId 子站id
     * @return 新闻列表
     */
    List<News> getNewsListBySiteId(Long siteId);

    /**
     * 查询新闻列表 前台新闻咨询页展示
     * @param siteId 子站id
     * @return 新闻列表
     */
    List<News> getNewsListMore(Long siteId);

    /**
     * 查询新闻详情 前台展示
     * @param id 新闻id
     * @return 新闻信息
     */
    News getNewsDetailById(Long id);

    /**
     * 查询后台新闻列表
     * @param siteId 子站id
     * @return 新闻列表
     */
    List<News> getNewsBackList(Long siteId);

    /**
     * 根据标签查询新闻数量
     * @param tagId 标签分类id
     * @return 影响的行数
     */
    int countNews(Long tagId);


}