<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message") == null)) {
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeval="";
    if(allCookies!=null){
        //we read 3 cookies
        for(Cookie c:allCookies){
            //get one by one
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeval=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    Username:<input type="text" name="username" value="<%=username%>"><br/>

    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" value="1" <%=rememberMeval.equals("1") ?"checked":""%>/>RememberMe<br/>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
