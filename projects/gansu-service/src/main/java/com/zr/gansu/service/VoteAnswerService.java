package com.zr.gansu.service;

import com.zr.gansu.domain.Vote;
import com.zr.gansu.form.VoteForm;

/**
 * @Author
 * @Description
 * @Date
 * @Param [userOrder]userId, orderId, apply_man.apply_woman
 * apply_startdate,apply_enddate
 * @return void
 **/
public interface VoteAnswerService {

    int addVoteAnswer(VoteForm voteForm);
}
