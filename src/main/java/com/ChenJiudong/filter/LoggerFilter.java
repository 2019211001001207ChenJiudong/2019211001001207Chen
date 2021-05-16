package com.ChenJiudong.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in Filter-->doFilter()-before request go to servlet");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter-->doFilter()-after servlet- response");
    }
}