package com.zr.gansu.service;

import com.zr.gansu.domain.Vote;
import com.zr.gansu.form.VoteForm;
import com.zr.gansu.form.VoteOptionForm;

import java.util.List;
import java.util.Map;

/**
 *@ClassName NoticeController
 *@Desciption 投票service层接口
 *@Author Administrator
 *@Date 2019/2/12 15:00
 */
public interface VoteService {
    /***
     * @Author wanglidong
     * @Description 添加投票问题
     * @Date 2019/2/14 15:05
     * @Param [vote]
     * @return int
    **/
    int addVote(Vote vote);

    /***
     * @Author wanglidong
     * @Description  添加选项内容
     * @Date 2019/2/14 15:33
     * @Param [options voteId]
     * @return int
    **/
    int addVoteOption(List<VoteOptionForm> options, long voteId);

    /***
     * @Author wanglidong
     * @Description 根据课程id查询问题及选项
     * @Date 2019/2/15 14:33
     * @Param [courseId]
     * @return java.util.List<com.zr.gansu.domain.Vote>
    **/
    List<Vote> queryVote(long courseId);

    boolean queryAnswerIsClose(long courseId);
   /**
    * @Author wanglidong
    * @Description 该用户是否 加入该课程学习
    * @Date 2019/2/18 10:06
    * @Param [userId, courseId]
    * @return boolean
   **/
   boolean isStudyCourse(long userId,long courseId);

   /***
    * @Author wanglidong
    * @Description 根据投票问题id统计该问题选项的所占人数比例
    * @Date 2019/2/18 10:31
    * @Param [voteId]
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
   **/
   List <Map<String,Object>> countsVoteOption(long voteId);

   /***
    * @Author wanglidong
    * @Description 修改投票问题
    * @Date 2019/2/18 15:57
    * @Param [vote]
    * @return java.lang.Integer
   **/
   Integer modifyVote(VoteForm voteForm);

    /**
     * 删除投票问题
     * @param voteId
     * @return
     */
   Integer delVoteInfo(long voteId);

    /**
     * 删除选项
     * @param optionId
     * @return
     */
   Integer delVoteOption(long optionId);

    /**
     * 根据id查询问题
     */
    Vote queryById(Long voteId);

    /**
     * 根据问题id 添加选项
     * @param voteId
     * @param optionName
     * @param content
     * @return
     */
   Integer addVoteOptionById(Long voteId,String optionName,String content);
}
