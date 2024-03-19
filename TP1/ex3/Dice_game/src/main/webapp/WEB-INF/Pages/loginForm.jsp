<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/17/2024
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/login.css">
</head>
<body>
<div class="login">
    <form id="loginform" action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <label id="login" for="login">Username : </label><input  required name="login" type="text"><br>
        <label id="password" for="password">Password :</label><input required name="password" type="password"><br>
        <input type="submit" value="log in ">
    </form>
    <button class="register"> <a href="${pageContext.request.contextPath}/RegisterServlet">Register</a></button>
</div>
</body>
</html>
