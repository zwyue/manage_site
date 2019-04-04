package com.zr.gansu.common.pageHelper;

import java.lang.annotation.*;

/**
 * 分页注解
 *
 * @author zwy
 * @date 2018/12/7 9:28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PagingQuery {

    //页号参数名
    String pageNumParameterName() default "pageNum" ;

    //每页行数参数名
    String pageSizeParameterName() default "pageSize" ;

    //分页排序
    String orderParameterName() default "orderBy" ;
}
