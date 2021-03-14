package com.chenjiudong.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response)
            throws IOException {

        PrintWriter writer=response.getWriter();
        writer.println("Name:Chen Jiudong");
        writer.println("Id:2019211001001207");
        writer.println("Date and Time:");
    }
    public void doPost(HttpServletRequest request , HttpServletResponse response){

    }
}
