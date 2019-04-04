package com.zr.gansu.web.validate.code;

import com.alibaba.fastjson.JSON;
import com.zr.gansu.common.auth.ResultCode;
import com.zr.gansu.common.auth.ResultJson;
import com.zr.gansu.common.utils.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import static com.zr.gansu.common.auth.ResultCode.*;

/**
 * @description: 验证码校验过滤器
 * @author: KaiZhang
 * @create: 2019-03-10 14:09
 **/
public class ValidateCodeFilter extends OncePerRequestFilter {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //使用wrapper替代request,由于request只能读取一次
        ServletRequest requestWrapper=new BodyReaderHttpServletRequestWrapper(request);
        //匹配登录请求
        if(StringUtils.equals("/form/login",request.getRequestURI())
        &&StringUtils.equalsIgnoreCase(request.getMethod(),"post")){
            //读取request中数据
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(requestWrapper.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            //获取到参数map
            Map map = JSON.parseObject(responseStrBuilder.toString(),Map.class);
            String imageCode = (String) map.get("imageCode");
            //校验结果
            ResultCode resultCode =validate(new ServletWebRequest(request),imageCode);
            //if 出错
            if(resultCode.getCode()==0){
                //返回错误信息
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter printWriter = response.getWriter();
                String body = ResultJson.failure(resultCode).toString();
                printWriter.write(body);
                printWriter.flush();
                return;
            }
            //不做处理,直接跳转过滤器链
            }
        filterChain.doFilter(requestWrapper,response);
        }



    private ResultCode validate(ServletWebRequest request,String imageCode) {

        if (StringUtils.isBlank(imageCode)) {
            return VALIDATE_CODE_NULL;
        }
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);

        if (codeInSession == null) {
            return VALIDATE_CODE_NONE;
        }
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            return VALIDATE_CODE_EXPRIED;
        }
        if (!StringUtils.equals(codeInSession.getCode(), imageCode)) {
            return VALIDATE_CODE_NOT_EQUAL;
        }
        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
        return VALIDATE_SUC;
    }

}
