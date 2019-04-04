package com.zr.gansu.web.social.view;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description: 绑定视图
 * @author: KaiZhang
 * @create: 2019-03-14 13:59
 **/
public class GanSuConnectionView extends AbstractView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        if(model.get("connections") == null){
            response.getWriter().write("{\"result\":\"解绑成功\"}");
        }else {
            response.getWriter().write("{\"result\":\"绑定成功\"}");
        }
    }
}
