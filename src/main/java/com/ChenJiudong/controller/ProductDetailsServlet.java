package com.ChenJiudong.controller;

import com.ChenJiudong.dao.ProductDao;
import com.ChenJiudong.model.Category;
import com.ChenJiudong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con =null;
    @Override
    public void init()throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //get product by id
        try {
            if (request.getParameter("id") != null) {
                int productId = Integer.parseInt(request.getParameter("id"));
                ProductDao productDao = new ProductDao();
                Product product = productDao.findById(productId, con);
                request.setAttribute("p", product);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //forward
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
