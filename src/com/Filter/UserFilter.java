package com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wxk on 2017/4/5.
 */
//@WebFilter(filterName = " UserFilter", urlPatterns= "/Filter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
//        chain.doFilter(servletRequest, servletResponse);

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        String username = (String)session.getAttribute("username");

        if (username != null&&username!="") {
            // 如果现在存在了session，则请求向下继续传递
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 跳转到提示登陆页面
            servletRequest.getRequestDispatcher("Unlogin.jsp").forward(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
