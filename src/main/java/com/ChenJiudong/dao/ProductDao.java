package com.ChenJiudong.dao;

import com.ChenJiudong.model.Product;
import com.ChenJiudong.model.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3,product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save
    public int save(Product product, InputStream picture, Connection con) throws SQLException {
        int n = 0;
        System.out.println("IN SAVE");
        String sql = "insert into Product(ProductName,ProductDescription,Picture,Price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        System.out.println(product.getProductName());
        pt.setString(1, product.getProductName());
        System.out.println(product.getProductDescription());
        pt.setString(2, product.getProductDescription());
        if(picture!=null) {
            //for sql server
            System.out.println(picture);
            pt.setBinaryStream(3, picture);
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        System.out.println(product.getPrice());
        pt.setDouble(4, product.getPrice());
        System.out.println(product.getCategoryId());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        System.out.println(n);
        if (n > 0) {
            return n;
        }
        return 0;
    }
    @Override
    public int delete(Integer productId, Connection con)throws SQLException {
        int n = 0;
        String sql = "delete from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }
    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update Product set ProductName=?,ProductDescription=?,Picture=?,Price=?,CategoryId=? where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            pt.setBinaryStream(3, instance.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }


    @Override
    public Product findById(Integer productId, Connection con) {
        Product product = null;
        String sql="select * from Product where productId=?";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.setInt(1,productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        List<Product> listuser = null;
        String sql="select * from Product where categoryId=?";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.setInt(1,categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
                listuser.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> listuser = null;
        String sql="select * from Product where price<=ANY(select price from Product) or price>=ANY(select price from Product)";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.setDouble(1,maxPrice);
            pt.setDouble(1,minPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
                listuser.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> listuser = null;
        String sql="select * from Product ";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
                listuser.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> listuser = null;
        String sql="select * from Product where productName=?";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.setString(1,productName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
                listuser.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> listuser = null;
        String sql="select * from Product where productId=?";
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.setInt(1,productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setPrice(rs.getDouble("price"));
                product.setPicture(rs.getBinaryStream("picture"));
                listuser.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }
}

