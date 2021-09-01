package com.example.servlet_test;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        String name = config.getInitParameter("project");
        System.out.println(name);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("test doFilter");
        chain.doFilter(request, response);
    }
}
