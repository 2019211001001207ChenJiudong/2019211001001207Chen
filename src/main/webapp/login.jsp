<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
Login <br>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<input type="text" name="name"/></p>

    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
