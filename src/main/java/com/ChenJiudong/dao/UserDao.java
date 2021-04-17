package com.ChenJiudong.dao;

import com.ChenJiudong.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1,user.getId());
            pr.setString(2,user.getUsername());
            pr.setString(3,user.getPassword());
            pr.setString(4,user.getEmail());
            pr.setString(5,user.getGender());
            pr.setDate(6, (java.sql.Date) user.getBirthDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr.execute();
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where username=? and password=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1,user.getUsername());
            pr.setString(2,user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set email=?,gender=?,birthdate=? where username=? and password=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1,user.getEmail());
            pr.setString(2,user.getGender());
            pr.setDate(3, (java.sql.Date) user.getBirthDate());
            pr.setString(4,user.getUsername());
            pr.setString(5,user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr.executeUpdate();
    }
    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        User user = null;
        String sqlQuery="select * from usertable where id=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setInt(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        User user = null;
        String sqlQuery="select * from usertable where username=? and password=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setString(1,username);
            pr.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where username=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setString(1,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where password=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setString(1,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where email=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setString(1,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }
    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where gender=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setString(1,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where birthdate=?";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
            pr.setDate(1, (java.sql.Date) birthDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable";
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }
}
