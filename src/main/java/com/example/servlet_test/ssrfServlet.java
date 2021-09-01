package com.example.servlet_test;

import com.google.common.net.InternetDomainName;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@WebServlet(name = "ssrfServlet", value = "/ssrfServlet")
public class ssrfServlet extends HttpServlet {
    public static Boolean securitySSRFUrlCheck(String url, String[] urlwhitelist) {
        try {
            URL u = new URL(url);
            // 只允许http和https的协议通过
            if (!u.getProtocol().startsWith("http") && !u.getProtocol().startsWith("https")) {
                return  false;
            }
            // 获取域名，并转为小写
            String host = u.getHost().toLowerCase();
            // 获取一级域名
            String rootDomain = InternetDomainName.from(host).topPrivateDomain().toString();

            for (String whiteurl: urlwhitelist){
                if (rootDomain.equals(whiteurl)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        PrintWriter writer = response.getWriter();
        String[] urlwhitelist = {"local.host"};
        if (!securitySSRFUrlCheck(url, urlwhitelist)) {
            writer.println("Error URL");
            return;
        }
        String htmlContent;

        URL u = new URL(url);
        try {
            URLConnection urlConnection = u.openConnection();//打开一个URL连接，并运行客户端访问资源。
            BufferedReader base = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));  //获取url中的资源
            StringBuffer html = new StringBuffer();
            while ((htmlContent = base.readLine()) != null) {
                html.append(htmlContent);  //htmlContent添加到html里面
            }
            base.close();

            writer.println(html);//响应中输出读取的资源
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
            writer.println("请求失败");
            writer.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
