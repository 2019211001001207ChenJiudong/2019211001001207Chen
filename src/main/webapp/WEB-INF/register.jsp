<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/24
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/"><!-- NOT JS VALIDATION -->
    username<input type="text" name="username"  required><br>
    password<input type="password" name="password" required> <br>
    email<input type="text" name="email"  required><br>
    Gender:<input type="radio"name="gender" value="Male" checked >Male
    <input type="radio" name="gender" value="Female">Female
    <br>
    Date of Birth:<input type="text name" name="birthDate" required><br>
    <input type="submit" value="Register">
</form>

</body>
</html
