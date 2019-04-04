package com.zr.gansu.service.impl;

import com.zr.gansu.dao.NoticeTextMapper;
import com.zr.gansu.domain.NoticeText;
import com.zr.gansu.service.NoticeTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName NoticeTextServiceImpl
 * @Author Administrator
 * @Date 2019/2/14 13:55
 */
@Slf4j
@Service
public class NoticeTextServiceImpl implements NoticeTextService {

    @Resource
    private NoticeTextMapper noticeTextMapper;

    /**
     * @Author liuhuan
     * @Description 新增公告内容
     * @Date 13:59 2019/2/14
     * @Param [content]
     * @return void
     **/
    @Override
    public Long addContent(String content) {
        NoticeText noticeText = new NoticeText();
        noticeText.setContent(content);
        noticeTextMapper.insert(noticeText);
        log.info("已成功插入内容");
        return noticeText.getId();
    }
}
