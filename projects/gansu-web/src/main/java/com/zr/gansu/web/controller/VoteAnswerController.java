package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.VoteAnswerMapper;
import com.zr.gansu.domain.Vote;
import com.zr.gansu.domain.VoteOption;
import com.zr.gansu.form.VoteForm;
import com.zr.gansu.form.VoteOptionForm;
import com.zr.gansu.service.VoteAnswerService;
import com.zr.gansu.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *@ClassName VoteOptionController
 *@Desciption 用户投票
 *@Author Administrator
 *@Date 2019/2/15 14:20
 *@return
 */
@Api(value = "投票相关操作",tags = "投票相关操作")
@Controller
@RequestMapping("/voteOption")
public class VoteAnswerController {

    @Resource
    private VoteService voteService;
    @Resource
    private VoteAnswerService voteAnswerService;
    @Resource
    private VoteAnswerMapper voteAnswerMapper;

    /***
     * @Author wanglidong
     * @Description  根据课程id查询投票的问题和选项
     * @Date 2019/2/15 14:28
     * @Param [courseId]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "根据课程id查询相关问题和选项",notes = "根据id查询相关信息")
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/queryVoteOption",method = RequestMethod.GET)
    public Map queryVoteOption(@RequestParam(name = "courserId") long courseId){
        List<Vote> vote = voteService.queryVote(courseId);
        if(ObjectUtil.isNotNull(vote)){
            return ResultUtils.success(vote);
        }
        return ResultUtils.error("没有相关的信息");
    }

    /***
     * @Author wanglidong
     * @Description  用户投票 TODO
     * @Date 2019/2/15 15:12
     * @Param [vote]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "投票操作",notes = "投票操作")
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/addAnswerVote",method = RequestMethod.POST)
    public  Map addAnswerVote(@RequestBody VoteForm voteForm){
        if(ObjectUtil.isNotNull(voteForm)&&ObjectUtil.isNotNull(voteForm.getCourseId())&&ObjectUtil.isNotNull(voteForm.getOptions())){

            //是否存在该问题
            Vote vote = voteService.queryById(voteForm.getId());
            if(ObjectUtil.isNotNull(vote)&&Constants.IS_DELETED_NO.equals(vote.getIsDeleted())){
            //取消判断是否已经到了截止时间 TODO
                long userId=1L;
                //判断该用户是否参与该课程的学习
                if(!voteService.isStudyCourse(userId,voteForm.getCourseId())){
                    return ResultUtils.error("请加入该课程的学习,再参与投票!");
                }
                    //查询是否已经投过票
                    Integer counts = voteAnswerMapper.queryAnswerIsExit(userId, voteForm.getId());
                    if(!Constants.EXECUTE_FAIL.equals(counts)){
                        return ResultUtils.error("你已经参与过投票!");
                    }
                Integer status = voteAnswerService.addVoteAnswer(voteForm);
                if(!status.equals(Constants.EXECUTE_FAIL)){
                    return ResultUtils.success("提交成功!");
                }
            }else{
                    return ResultUtils.error("该问题不存在!");
            }
        }
        return ResultUtils.error("提交失败!");
    }

    /***
     * @Author wanglidong
     * @Description  根据投票问题id统计该题选项的百分比例
     * @Date 2019/2/18 10:00
     * @Param [voteId, courseId]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "统计题目各个选项的百分比",notes = "各个选项的百分比")
    @ResponseBody
    @RequestMapping(value = "/countOptions",method = RequestMethod.GET)
    public Map VoteCounts(
            @ApiParam(name="voteId",value = "问题id",required = true)
            @RequestParam(name="voteId") long voteId){
        List<Map<String, Object>> maps = voteService.countsVoteOption(voteId);
        if(!Constants.EXECUTE_FAIL.equals(maps.size())){
            return ResultUtils.success(maps);
        }else{
            return ResultUtils.error("暂无数据!");
        }
    }
}
