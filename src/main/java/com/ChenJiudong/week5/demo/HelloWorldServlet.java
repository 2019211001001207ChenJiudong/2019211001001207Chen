package com.ChenJiudong.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    String name="chenjiudong";
    String id="2019211001001207";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        response.setContentType("textml;charset=utf-8");
        Date date=new Date();
        writer.println("name: "+name+"<br/>");
        writer.println("id: "+id+"<br/>");
        writer.println("Date and Time: "+date.toString()+"<br/>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}

