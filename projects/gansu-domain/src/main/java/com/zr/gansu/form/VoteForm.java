package com.zr.gansu.form;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 *@ClassName VoteForm
 *@Desciption 投票入参参数
 *@Author wanglidong
 *@Date 2019/2/19 15:13
 *@return
 */
@ApiModel(value = "package com.zr.gansu.form.VoteForm")
public class VoteForm {
    @ApiModelProperty(value ="投票问题id")
    private Long id;
    @ApiModelProperty(value ="问题")
    private String question;
    @ApiModelProperty(value ="题目类型(选项的内容)必填：1：文字，2:图片")
    private Integer type;
    @ApiModelProperty(value ="所属课程id")
    private Long courseId;
    @ApiModelProperty(value ="问题问题选项内容")
    private List<VoteOptionForm> options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<VoteOptionForm> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOptionForm> options) {
        this.options = options;
    }
}
