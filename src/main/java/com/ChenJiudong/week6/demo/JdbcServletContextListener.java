package com.ChenJiudong.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Object;

@WebListener()
public class JdbcServletContextListener implements ServletContextListener {

    public JdbcServletContextListener() {
        System.out.println("-----");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Connection dbConn;
        ServletContext c = servletContextEvent.getServletContext();
        try {
            Class.forName(c.getInitParameter("driver"));
            dbConn = DriverManager.getConnection(c.getInitParameter("url"),
                    c.getInitParameter("Username"),
                    c.getInitParameter("Password"));
            c.setAttribute("dbConn",dbConn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute("dbConn");
    }
}
