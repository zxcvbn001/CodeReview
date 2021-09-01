package com.example.servlet_test;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenFilter")
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String name = request.getParameter("name");
        if("jack".equals(name)){
            chain.doFilter(request, response);
        }else{
            PrintWriter out = response.getWriter();
            out.println("No Authority!");
        }
    }
}
