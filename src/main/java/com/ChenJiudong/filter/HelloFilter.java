package com.ChenJiudong.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",urlPatterns = {"/home","/Login","/register.jsp"})
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("i am in h=HelloFilter-->init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
       System.out.println("i am in Filter-->doFilter()-before request go to servlet");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter-->doFilter()-after servlet- response");
    }
}
