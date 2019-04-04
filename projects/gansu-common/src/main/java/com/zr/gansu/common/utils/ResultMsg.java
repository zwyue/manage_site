package com.zr.gansu.common.utils;

/**
 * @author KaiZhang
 */

public enum ResultMsg {
    /* 成功状态码 */
    SUCCESS("成功"),
    /* 成功状态码 */
    FAILED("失败"),


    /* 参数错误 */
    PARAM_IS_INVALID("参数无效"),
    PARAM_IS_BLANK("参数为空"),
    PARAM_TYPE_BIND_ERROR("参数类型错误"),
    PARAM_NOT_COMPLETE("参数缺失"),
    PARAM_INSIDE_WRONG("接口内部参数错误"),

    /* 用户错误 */
    USER_NOT_LOGGED_IN("用户未登录"),
    USER_LOGIN_ERROR("账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN("账号已被禁用"),
    USER_NOT_EXIST("用户不存在"),
    USER_HAS_EXISTED("用户已存在"),
    USER_PASS_MSG_NOT_COMPLETE("用户密码信息缺失"),
    USER_PASS_BLANK("密码为空"),
    USER_PASS_WRONG("密码错误"),
    STU_NO_BLANK("学号为空"),

    /* 业务错误 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST("某业务出现问题"),

    /* 系统错误 */
    SYSTEM_INNER_ERROR("系统繁忙，请稍后重试"),

    /* 数据错误 */
    RESULE_DATA_NONE("数据未找到"),
    DATA_IS_WRONG("数据有误"),
    DATA_ALREADY_EXISTED("数据已存在"),
    DATA_IS_DELETED("数据已删除"),

    /* 接口错误 */
    INTERFACE_INNER_INVOKE_ERROR("内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR("外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT("该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID("接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT("接口请求超时"),
    INTERFACE_EXCEED_LOAD("接口负载过高"),

    /* 自定义错误 */
    YOU_HAVE_APPLIED_TO_BE_A_VOLUNTEER("你已经申请或是志愿者"),
    USERS_DID_NOT_APPLY_TO_BE_VOLUNTEERS("用户未申请成为志愿者"),

    THIS_CLASSIFICATION_HAS_BEEN_USED_BY_COMMODITIES("该分类已被商品使用"),
    THE_CATEGORY_ALREADY_EXISTS("已存在该分类"),

    INVENTORY_SHORTAGE("兑换失败，库存不足"),

    ADD_SUCESS("添加成功"),
    ADD_ERROR("添加失败"),
    ADD_NEWS_NOTNULL("新闻信息不能为空"),
    TAG_HAVE_NEWS("此标签下已存在新闻，不可删除！"),

    ADD_SITE_NOTNULL("子站信息不能为空"),
    ADD_THEME_NOTNULL("主题信息不能为空"),
    ADD_BANNER_NOTNULL("banner图信息不能为空"),

    ADD_QUESTIONNAIRE_NOTNULL("调查问卷信息不能为空"),
    ADD_QUESTION_NOTNULL("问题信息不能为空"),
    ADD_ANSWER_NOTNULL("用户回答问卷数据不能为空"),
    ADD_QUESTION_ID_NOTNULL("问题id不能为空"),
    QUESTION_ID_NOT_EXIST("问题id不存在"),

    ID_NOTNULL("id不能为空"),

    UPDATE_SUCESS("修改成功"),
    UPDATE_ERROR("修改失败"),

    FIND_SUCCESS("查询成功"),
    FIND_ERROR("查询失败"),

    DELETE_SUCESS("删除成功"),
    DELETE_ERROR("删除失败"),


    RELEASE_SUCESS("发布成功"),
    RELEASE_ERROR("发布失败"),

    /* 审核状态 */
    AUDIT_SUCCESSED("已通过审核,请勿重复审核"),
    AUDIT_FAILED("已完成审核，审核未通过"),
    AUDIT_SUCCESS("完成审核"),

    /* 收藏课程成功 */
    COLLECTION_TAG_SUCCESS("收藏课程标签成功"),

    /* 退出课程学习计划 */
    END_STUDY_PALN("退出课程学习计划"),

    /*兑换商品*/
    YOUR_POINTS_ARE_NOT_ENOUGH("您的积分不够"),

    /* 权限错误 */
    PERMISSION_NO_ACCESS("无访问权限");


    ResultMsg(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }

    private String msg;
}
