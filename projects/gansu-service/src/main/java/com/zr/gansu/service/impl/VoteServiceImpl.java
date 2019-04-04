package com.zr.gansu.service.impl;    /**
 * @Author
 * @Description
 * @Date
 * @Param [userOrder]userId, orderId, apply_man.apply_woman
 * apply_startdate,apply_enddate
 * @return void
 **/

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.dao.UserCourseMapper;
import com.zr.gansu.dao.VoteAnswerMapper;
import com.zr.gansu.dao.VoteMapper;
import com.zr.gansu.dao.VoteOptionMapper;
import com.zr.gansu.domain.Vote;
import com.zr.gansu.domain.VoteOption;
import com.zr.gansu.form.VoteForm;
import com.zr.gansu.form.VoteOptionForm;
import com.zr.gansu.service.CourseService;
import com.zr.gansu.service.VoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *@ClassName VoteServiceImpl
 *@Desciption service实现类
 *@Author Administrator
 *@Date 2019/2/14 11:43
 *@return
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Resource
    private VoteMapper voteMapper;
    @Resource
    private VoteOptionMapper voteOptionMapper;
    @Resource
    private CourseService courseService;
    @Resource
    private UserCourseMapper userCourseMapper;
    @Resource
    private VoteAnswerMapper voteAnswerMapper;

    @Override
    public int addVote(Vote vote) {
        //查询该课程是否存在 //TODO 创建人未加
        if(ObjectUtil.isNotNull(vote.getCourseId())){
            if(courseService.isExist(vote.getCourseId())){
                //补充相关信息
                Date timeNow =new Date(System.currentTimeMillis());
                vote.setGmtCreate(timeNow);
                vote.setGmtModified(timeNow);
                //保存
                return voteMapper.insertSelective(vote);
            }
        }
        return 0;
    }

    @Override
    public int addVoteOption(List<VoteOptionForm> options, long voteId) {

            for(VoteOptionForm optionForm:options) {
                VoteOption option=new VoteOption();
                //对象映射
                BeanUtils.copyProperties(optionForm,option);
                //补充先关信息
                Date timeNow = new Date(System.currentTimeMillis());
                option.setVoteId(voteId);
                option.setGmtCreate(timeNow);
                option.setGmtModified(timeNow);
                //插入信息
                Integer  status = voteOptionMapper.insertSelective(option);
                if(status.equals(Constants.EXECUTE_FAIL)){
                    return 0;
                }
            }
                return 1;
    }

    @Override
    public List<Vote> queryVote(long courseId) {
        //查询投票问题
        List<Vote>  vote= voteMapper.selectByCourseId(courseId);
        if(ObjectUtil.isNotNull(vote)){
           for(Vote queryVote:vote){
                //根据投票问题查询选项内容
                    List<VoteOption> voteOptions = voteOptionMapper.selectOptionByVoteId(queryVote.getId());
                    queryVote.setOptions(voteOptions);
            }
            return vote;
        }
        return null;
    }

    @Override
    public boolean queryAnswerIsClose(long courseId) {

        Integer status = voteMapper.queryAnswerIsClose(courseId, new Date(System.currentTimeMillis()));
        if(Constants.EXECUTE_FAIL.equals(status)){
            //未到截止时间
          return  true;
        }
        return false;
        }


    @Override
    public boolean isStudyCourse(long userId, long courseId) {
        Integer  counts = userCourseMapper.queryByCourseId(userId, courseId);
        if(!counts.equals(Constants.EXECUTE_FAIL)){
            //有加入学习
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> countsVoteOption(long voteId) {
        //查询该题的选项
        List<VoteOption> voteOptions = voteOptionMapper.selectOptionByVoteId(voteId);
        //统计该题下每个选项的所占比例
        if(ObjectUtil.isNotNull(voteOptions)){
            List<Map<String,Object>> list=new ArrayList<>();
            for(VoteOption option:voteOptions){
                //统计每个选项的百分比
                Map map = voteAnswerMapper.countAnswerNumberByVoteId(voteId, option.getOption());
                if(ObjectUtil.isNotNull(map)){
                    list.add(map);
                }
            }
            return list;
        }
        return null;
    }

    @Override
    public Integer modifyVote(VoteForm voteForm) {
        if(ObjectUtil.isNotNull(voteForm.getId())){
            Vote votes= voteMapper.selectByPrimaryKey(voteForm.getId());
            Date timeNow=new Date(System.currentTimeMillis());
            if(votes.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                //修改选项内容
                if(ObjectUtil.isNotNull(voteForm.getOptions())){
                    for(VoteOptionForm optionForm:voteForm.getOptions()){
                        //查询该项是否被删除
                        VoteOption options = voteOptionMapper.selectByPrimaryKey(optionForm.getId());
                            if(options.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                                //未删除
                                //补充相关信息
                                VoteOption option=new VoteOption();
                                //对象映射
                                BeanUtils.copyProperties(optionForm,option);
                                option.setGmtModified(timeNow);
                                voteOptionMapper.updateByPrimaryKeySelective(option);
                            }
                    }
                }
                Vote vote=new Vote();
                //对象映射
                BeanUtils.copyProperties(voteForm,vote);
                //保存投票问题
                vote.setGmtModified(timeNow);
                return voteMapper.updateByPrimaryKeySelective(vote);
            }
            return 2;
        }
        return 0;
    }

    @Override
    public Integer delVoteInfo(long voteId) {
        Vote vote = voteMapper.selectByPrimaryKey(voteId);
        if(ObjectUtil.isNotNull(vote)){
            if(vote.getIsDeleted().equals(Constants.IS_DELETED_NO)){

                    //删除该题下的选项
                    List<VoteOption> voteOptions = voteOptionMapper.selectOptionByVoteId(voteId);
                    for(VoteOption option:voteOptions){
                        if(option.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                            //更新删除状态
                            option.setIsDeleted(Constants.IS_DELETED_YES);
                            Integer delStatus = voteOptionMapper.updateByPrimaryKeySelective(option);
                            if(delStatus.equals(Constants.EXECUTE_FAIL)){
                                break;
                            }
                        }
                    }
                //变更删除状态
                vote.setIsDeleted(Constants.IS_DELETED_YES);
                Integer  delVote = voteMapper.updateByPrimaryKeySelective(vote);
                return delVote;
            }
            return 2;
        }
        return 0;
    }

    @Override
    public Integer delVoteOption(long optionId) {
        VoteOption option = voteOptionMapper.selectByPrimaryKey(optionId);
        if(ObjectUtil.isNotNull(option)){
            if(option.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                option.setIsDeleted(Constants.IS_DELETED_YES);
               return voteOptionMapper.updateByPrimaryKeySelective(option);
            }
            return 2;
        }
        return 0;
    }

    @Override
    public Vote queryById(Long voteId) {
       return voteMapper.selectByPrimaryKey(voteId);
    }


    @Override
    public Integer addVoteOptionById(Long voteId, String optionName, String content) {
        Integer exitOption = voteOptionMapper.isExitOption(voteId, optionName);
        if(exitOption.equals(Constants.EXECUTE_FAIL)){
            //不存在一样选项
            VoteOption option=new VoteOption();
            //补充信息
            Date time=new Date(System.currentTimeMillis());
            option.setVoteId(voteId);
            option.setOption(optionName);
            option.setContent(content);
            option.setGmtCreate(time);
            option.setGmtModified(time);
           return voteOptionMapper.insertSelective(option);
        }
        return 2;
    }
}
