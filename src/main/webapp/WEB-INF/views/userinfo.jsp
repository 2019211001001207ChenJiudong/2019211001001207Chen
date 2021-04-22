<%@ page import="com.ChenJiudong.model.User" %>
<%@ page import="java.net.CookieStore" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/11
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="textml;charset=UTF-8" language="java"%>
<%
  //read cookies
  Cookie [] allCookies=request.getCookies();
  for(Cookie c:allCookies){
   //get one by one
   out.println("<br/>"+c.getName()+"---"+c.getValue());
  }
%>
<%
    User u = (User)session.getAttribute("user");

%>
<h2>User Info</h2>
<table>
    <tr><td>Username</td><td><%=u.getUsername()%></td> </tr>
    <tr><td>Password</td><td><%=u.getPassword()%></td> </tr>
    <tr><td>Email</td> <td><%=u.getEmail()%></td> </tr>
    <tr><td>Gender</td><td><%=u.getGender()%></td> </tr>
    <tr><td>Birthdate</td> <td><%=u.getBirthDate()%></td></tr>
    <tr> <a href="updateUser"> Update User</a></tr>
</table>


<%@include file="footer.jsp" %>
