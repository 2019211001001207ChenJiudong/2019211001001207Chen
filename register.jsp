<%--
  Created by IntelliJ IDEA.
  User: 鑫鑫
  Date: 2021/3/14
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form><!-- NOT JS VALIDATION -->
    username:<input type="text" name="username"  required><br>
    password:<input type="password" name="password" required> <br>
    email:<input type="email" name="email"  required><br>
    Gender<input type="radio"name="myCheck" value="Male" checked >Male
    <input type="radio" name="myCheck" value="Female">Female
    <br>
    BirthDate:<input type="date"  required><br>
    <input type="submit" value="Register">
</form>

</body>

</html>
