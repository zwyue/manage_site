package com.zr.gansu.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 *@ClassName PopularActivityForm
 *@Desciption 热门活动参数类
 *@Author wanglidong
 *@Date 2019/2/19 10:54
 *@return
 */
@Data
@ApiModel(value = "com.zr.gansu.form.OldAgeActivityForm",description ="老年活动参数类" )
public class OldAgeActivityForm {

    @ApiModelProperty(value = "活动id ")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 活动地址
     */
    @ApiModelProperty(value = "活动地址")
    private String address;
    /**
     * 封面图地址
     */
    @ApiModelProperty(value = "封面图地址")
    private String coverUrl;
    /**
     * 承办方
     */
    @ApiModelProperty(value = "承办方")
    private String organizer;

    /**
     * 活动开始时间
     */
    @ApiModelProperty(value = "活动开始时间", example = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @ApiModelProperty(value = "活动结束时间", example = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 热门活动内容
     */
    @ApiModelProperty(value = "热门活动内容")
    private String contentText;

    @ApiModelProperty(value = "参与人数",required = false)
    private Integer totalPeople;

    @ApiModelProperty(value = "活动内容ID",required = false)
    private Long contentId;

    @ApiModelProperty(value = "活动类型",required = true,example = "1：老年活动，2：兴趣课程")
    private Integer type;

}
