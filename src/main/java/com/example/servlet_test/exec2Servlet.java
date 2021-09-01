package com.example.servlet_test;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

@WebServlet(name = "exec2Servlet", value = "/exec2Servlet")
public class exec2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Hook resolveClass
        AntObjectInputStream ois = new AntObjectInputStream(request.getInputStream());
         */

        ValidatingObjectInputStream ois = new ValidatingObjectInputStream(request.getInputStream());
        try {
            ois.accept(List.class);
            ois.readObject();
            //Integer I = pra.get(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }

}
