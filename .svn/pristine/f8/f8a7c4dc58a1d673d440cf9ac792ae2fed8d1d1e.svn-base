package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Vote;
import com.zr.gansu.domain.VoteOption;
import com.zr.gansu.form.VoteForm;
import com.zr.gansu.form.VoteOptionForm;
import com.zr.gansu.service.CourseService;
import com.zr.gansu.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *@ClassName VoteController
 *@Desciption 投票控制层
 *@Author Administrator
 *@Date 2019/2/14 11:38
 *@return
 */
@Api(value = "投票管理层",tags = {"投票管理控制层"})
@Controller
@RequestMapping("/admin/vote")
public class AdminVoteController {

    @Resource
    private VoteService voteService;

    @Resource
    private CourseService courseService;

    /***
     * @Author wanglidong
     * @Description  添加投票问题和选项
     * @Date 2019/2/14 14:57
     * @Param [vote, option]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "添加投票问题和选项内容",notes = "投票问题和选项信息新增")
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/addVoteInfo",method = RequestMethod.POST)
    public Map addVoteInfo(
            @ApiParam(value = "投票问题和选项内容参数", required = true)
            @RequestBody VoteForm voteForm){
        List<VoteOptionForm> options=voteForm.getOptions();

        //判断添加的内容是否为空
        if(ObjectUtil.isNotNull(voteForm)&&ObjectUtil.isNotNull(options)){
            if(courseService.isExist(voteForm.getCourseId())){
            //先添加投票问题
                Vote vote=new Vote();
                //对象映射
                BeanUtils.copyProperties(voteForm,vote);
                Integer voteStatus = voteService.addVote(vote);
                if(!voteStatus.equals(Constants.EXECUTE_FAIL)){
                    //添加选项内容
                    Integer optionStatus = voteService.addVoteOption(options, vote.getId());
                    if(!optionStatus.equals(Constants.EXECUTE_FAIL)){
                        return ResultUtils.success("添加成功！");
                    }
                }else{
                    return ResultUtils.error("添加失败！");
                }
            }
            return ResultUtils.error("添加失败！对应课程信息不存在!");
        }
        return ResultUtils.error("添加的相关内容不能为空！");
    }

    /***
     * @Author wanglidong
     * @Description  修改投票问题 和选项
     * @Date 2019/2/18 15:54
     * @Param [vote]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "修改投票问题和选项",notes ="修改问题和选项内容" )
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/modifyVote",method = RequestMethod.POST)
    public Map modifyVote(
            @ApiParam(value = "投票问题和选项参数",required = true)
            @RequestBody VoteForm voteForm){
        //必须字段id
        Integer status = voteService.modifyVote(voteForm);
        if(status.equals(Constants.IS_DELETED_ALREADY)){
            return ResultUtils.error("该记录不存在,如有疑问联系管理员!");
        }else if(status>0){
            return ResultUtils.success("修改成功!");
        }
        return ResultUtils.error("修改失败!");
    }

    /***
     * @Author wanglidong
     * @Description 根据id删除投票问题:(删除各选项内容)
     * @Date 2019/2/18 17:02
     * @Param [voteId]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "删除投票问题",notes = "根据id删除问题和各选项内容")
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/delVote",method = RequestMethod.POST)
    public Map delVoteInfo(@ApiParam(value = "问题voteId参数",required = true) @RequestParam(name="voteId") long voteId){
        Integer status = voteService.delVoteInfo(voteId);
        if(status.equals(Constants.IS_DELETED_ALREADY)){
            return ResultUtils.error("请勿重复操作!");
        }else if(status.equals(Constants.IS_DELETED_NO)){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    /***
     * @Author wanglidong
     * @Description 删除单个选项内容信息
     * @Date 2019/2/18 17:06
     * @Param [optionId]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "删除选项",notes ="选项单个删除")
    @ResponseBody
    @Transactional(rollbackFor =Exception.class)
    @RequestMapping(value = "/delVoteOption",method = RequestMethod.POST)
    public Map delVoteOptionId(@ApiParam(value = "单个选项optionId参数",required =true) @RequestParam(name="optionId") long optionId){
        Integer option = voteService.delVoteOption(optionId);
        if(option.equals(Constants.IS_DELETED_ALREADY)){
            return ResultUtils.error("请勿重复操作!");
        }else if(option>0){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    @Log
    @ResponseBody
    @ApiOperation(value = "添加选项内容",notes ="根据问题Id添加选项内容")
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/addOptionByVoteId",method = RequestMethod.POST)
    public Map addVoteOption(@ApiParam(value = "问题id",required = true)@RequestParam(name = "voteId") Long voteId,
                             @ApiParam(value = "选项名称",required = true)@RequestParam(name = "optionName") String optionName,
                             @ApiParam(value = "选项内容",required = true)@RequestParam(name = "content")String content){
        Vote vote = voteService.queryById(voteId);
        if(ObjectUtil.isNotNull(vote)&&vote.getIsDeleted().equals(Constants.IS_DELETED_NO)){
            Integer status = voteService.addVoteOptionById(voteId, optionName, content);
            if(status.equals(Constants.REPEATED_SUBMIT)){
                return ResultUtils.error("该选项名已被使用!");
            }else if(status.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.error("添加失败!");
            }else{
                return ResultUtils.success("添加成功!");
            }
        }else{
            return ResultUtils.error("该问题不存在!");
        }
    }
}
