package com.ChenJiudong.controller;

import com.ChenJiudong.dao.ProductDao;
import com.ChenJiudong.model.Category;
import com.ChenJiudong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)//16MB
public class AddProductServlet extends HttpServlet {

    Connection con = null;


    @Override
    public void init() throws ServletException {
        con =(Connection)getServletContext().getAttribute("con");

    }

    public void destroy() {
        super.destroy();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);
        String path = "/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get Parameters
        String productName = request.getParameter("productName");
        Double price =  request.getParameter("price")!= null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription = request.getParameter("productDescription");
        //picture

        InputStream inputStream = null;
        Part filePart = request.getPart("picture");

        if (filePart != null){
            System.out.println("file name :" + filePart.getName() + "size" + filePart.getSize() + "file type" + filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        //set in model

        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setCategoryId(categoryId);

        ProductDao dao = new ProductDao();
        int i = 0;
        try{
            i = dao.save(product,inputStream,con);
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (i>0){
          //  response.sendRedirect("productList");//next class
        }
    }

}//end post

