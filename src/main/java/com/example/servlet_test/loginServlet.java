package com.example.servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;


@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //System.out.println(username+ "\n" +password);
        Cookie username = new Cookie("username", URLEncoder.encode(request.getParameter("u"), "UTF-8"));
        username.setMaxAge(60*60*24);  //设置cookie过期时间为24小时
        response.addCookie(username);
        out.println("success");
    }
}
