package com.zr.gansu.common.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.zr.gansu.common.log.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.zr.gansu.common.constants.Constants.PagingDefaultValue.COUNT;
import static com.zr.gansu.common.constants.Constants.PagingDefaultValue.PAGE_NUM;
import static com.zr.gansu.common.constants.Constants.PagingDefaultValue.PAGE_SIZE;

/**
 * copyright    <a href="http://www.qaqavr.com/">中锐</a>
 * <pre>
 *     @author      zwy
 *     @date        2019/3/18 10:50
 *     email        1092478224@qq.com
 *     desc         分页注解
 * </pre>
 */
@Aspect
@Component
public class PagingAspect {

    private static final Logger logger = LoggerFactory.getLogger(PagingAspect.class);

    @Around("@annotation(pagingQuery)")
    public Object pagingQuery(ProceedingJoinPoint joinPoint, PagingQuery pagingQuery) throws Throwable {

        logger.info(".............切面进入分页...............");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Class<?> returnType = signature.getMethod().getReturnType();
        //切点方法是否返回的是list
        if (returnType == List.class) {

            //是否有分页参数pageNum和pageSize
            String pageNumParameterName = pagingQuery.pageNumParameterName();
            String pageSizeParameterName = pagingQuery.pageSizeParameterName();
            String orderByParameterName = pagingQuery.orderParameterName();
            //获取request，从中获取分页参数
            ServletRequestAttributes currentRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();
            HttpServletRequest request = currentRequestAttributes.getRequest();
            String pageNum = request.getParameter(pageNumParameterName);
            String pageSize = request.getParameter(pageSizeParameterName);
            String orderBy = request.getParameter(orderByParameterName);
            try {
                if(StringUtil.isEmpty(orderBy)){
                    PageHelper.startPage(Integer.valueOf(StringUtil.isEmpty(pageNum)?PAGE_NUM:pageNum),
                            Integer.valueOf(StringUtil.isEmpty(pageSize)?PAGE_SIZE:pageSize),COUNT);
                }else {
                    PageHelper.startPage(Integer.valueOf(StringUtil.isEmpty(pageNum)?PAGE_NUM:pageNum),
                            Integer.valueOf(StringUtil.isEmpty(pageSize)?PAGE_SIZE:pageSize),orderBy);
                }
                Object result = joinPoint.proceed();
                return (List<?>) result;
            } finally {
                //保证线程变量被清除
                if (PageHelper.getLocalPage() != null){
                    PageHelper.clearPage();
                }
            }
        }
        return joinPoint.proceed();
    }
}
