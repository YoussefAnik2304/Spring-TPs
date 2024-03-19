<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/17/2024
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/register.css">
</head>
<body>
<div class="register">
    <form action="/RegisterServlet" method="post">
        username : <input type="text" name="username">
        password : <input type="password" name="password">
        <input type="submit" value="register">
    </form>
</div>
</body>
</html>
