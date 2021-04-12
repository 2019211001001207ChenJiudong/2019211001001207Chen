<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/11
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="textml;charset=UTF-8" language="java"%>

<h2>User Info</h2>
    <table border="1" >
        <tr>
            <td>Username</td><td><%=request.getAttribute("Username")%></td> </tr>
            <td>Password</td><td><%=request.getAttribute("Username")%></td> </table>
            <td>Email</td> <td><%=request.getAttribute("Email")%></td> </tr>
            <td>Gender</td><td><%=request.getAttribute("Gender")%></td> </tr>
            <td>Birthdate</td> <td><%=request.getAttribute("Birthdate")%></td>
        </tr>
    </table>
<%@include file="footer.jsp" %>
