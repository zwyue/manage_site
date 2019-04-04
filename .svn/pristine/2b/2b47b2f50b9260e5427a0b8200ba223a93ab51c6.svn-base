package com.zr.gansu.service.impl;

import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.dao.VoteAnswerMapper;
import com.zr.gansu.dao.VoteOptionMapper;
import com.zr.gansu.domain.Vote;
import com.zr.gansu.domain.VoteAnswer;
import com.zr.gansu.domain.VoteOption;
import com.zr.gansu.form.VoteForm;
import com.zr.gansu.form.VoteOptionForm;
import com.zr.gansu.service.VoteAnswerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName VoteAnswerServiceImpl
 *@Desciption 用户投票serviceImpl实现类
 *@Author Administrator
 *@Date 2019/2/15 15:02
 *@return
 */
@Service
public class VoteAnswerServiceImpl implements VoteAnswerService {

    @Resource
    private VoteAnswerMapper voteAnswerMapper;

    /***
     * @Author wanglidong
     * @Description 添加用户投票信息
     * @Date 2019/2/15 15:05
     * @Param [vote]
     * @return int
    **/
    @Override
    public int addVoteAnswer(VoteForm voteForm) {
        //得到用户所选内容
        List<VoteOptionForm> options = voteForm.getOptions();
        Date timeNow=new Date(System.currentTimeMillis());
        //用户信息 TODO
        long userId=1L;
        for(VoteOptionForm option:options){
                VoteAnswer voteAnswer=new VoteAnswer();
                //补充相关信息
                voteAnswer.setUserId(userId);
                voteAnswer.setAnswer(option.getOption());
                voteAnswer.setVoteId(voteForm.getId());
                voteAnswer.setGmtCreate(timeNow);
                voteAnswer.setGmtModified(timeNow);
                Integer status = voteAnswerMapper.insertSelective(voteAnswer);
                if(status.equals(Constants.EXECUTE_FAIL)){
                    return 0;
                }
        }
        return 1;
    }
}
