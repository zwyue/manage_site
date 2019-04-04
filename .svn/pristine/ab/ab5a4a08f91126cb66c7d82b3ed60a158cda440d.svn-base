package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.NewsMapper;
import com.zr.gansu.dao.NewsTextMapper;
import com.zr.gansu.domain.News;
import com.zr.gansu.domain.NewsText;
import com.zr.gansu.domain.vo.NewsVo;
import com.zr.gansu.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: yufei
 * @Description:新闻接口实现类
 * @Date: Create in 13:06 2018/12/24
 */
@Service
public class NewsServiceImpl implements NewsService {

    private final
    NewsMapper newsMapper;

    private final
    NewsTextMapper newsTextMapper;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper, NewsTextMapper newsTextMapper) {
        this.newsMapper = newsMapper;
        this.newsTextMapper = newsTextMapper;
    }


    /**
     * 新增新闻纪录，同时关联新闻内容表
     * @return 影响的行数
     */
    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(NewsVo newsVo) {
        //先插入新闻内容表记录，同时返回主键id
        NewsText newsText = new NewsText();
        newsText.setContent(newsVo.getContent());
        int newsTextResult = newsTextMapper.insertSelective(newsText);
        if(newsTextResult>0){
            //插入新闻表记录
            //从用户信息中查找子站id
            newsVo.setSiteId(1L);
            newsVo.setContentId(newsText.getId());
            newsVo.setGmtCreate(new Date());
            int newsResult = newsMapper.insertSelective(newsVo);
            if(newsResult>0){
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    /**
     * 修改新闻
     * @return 影响的行数
     */
    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(NewsVo newsVo) {
        //修改新闻信息
        newsVo.setGmtModified(new Date());
        int newsResult = newsMapper.updateByPrimaryKeySelective(newsVo);
        if (newsResult>0) {
            //修改新闻内容信息
            NewsText newsText = new NewsText();
            newsText.setId(newsVo.getContentId());
            newsText.setContent(newsVo.getContent());
            int newsTextResult = newsTextMapper.updateByPrimaryKeySelective(newsText);
            if(newsTextResult>0){
                return 1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    @Override
    @Log
    public News selectByPrimaryKey(Long id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int deleteNewsById(Long id) {
        return newsMapper.deleteNewsById(id);
    }

    @Override
    public List<News> getNewsListBySiteId(Long siteId) {
        return newsMapper.getNewsListBySiteId(siteId);
    }

    @Override
    @Log
    public List<News> getNewsListMore(Long siteId) {
        return newsMapper.getNewsListMore(siteId);
    }

    @Override
    @Log
    public News getNewsDetailById(Long id) {
        return newsMapper.getNewsDetailById(id);
    }

    @Override
    @Log
    public List<News> getNewsBackList(Long siteId) {
        return newsMapper.getNewsBackList(siteId);
    }

    @Override
    @Log
    public int countNews(Long tagId) {
        return newsMapper.countNews(tagId);
    }
}
