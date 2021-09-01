package com.example.servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "execServlet", value = "/execServlet")
public class execServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getParameter("ip");
        String cmd="ping " + ip;
        try
        {
            Process proc =Runtime.getRuntime().exec(cmd);
            InputStream fis=proc.getInputStream();
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            PrintWriter out = response.getWriter();
            while((line=br.readLine())!=null)
            {
                out.println(line);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
