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

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init()throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set all category into request
        try {

            Category category = new Category();
            List<Category> categoryList = category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //set all product into request
        ProductDao productDao=new ProductDao();
        List<Product> productList=null;
        try{

            if(request.getParameter("categoryId")==null){
            productList=productDao.findAll(con);
            request.setAttribute("productList",productList);
            }else {
                int categoryId=Integer.parseInt(request.getParameter("categoryId"));
                productDao.findByCategoryId(categoryId,con);
                request.setAttribute("productList",productList);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //forward
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
