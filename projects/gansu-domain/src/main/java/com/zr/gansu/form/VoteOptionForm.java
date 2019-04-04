package com.zr.gansu.form;

import io.swagger.annotations.ApiModelProperty;

/**
 *@ClassName VoteOptionForm
 *@Desciption 问题选项参数
 *@Author wanglidong
 *@Date 2019/2/19 15:18
 *@return
 */
public class VoteOptionForm {
    @ApiModelProperty(value ="选项id")
    private Long id;
    @ApiModelProperty(value ="选项")
    private String option;
    @ApiModelProperty(value ="选项内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
