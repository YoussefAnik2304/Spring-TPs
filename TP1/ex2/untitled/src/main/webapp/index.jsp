<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/4/2024
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="login">
    <form action="<%=request.getContextPath()%>/loginServlet" method="post">
        username : <input type="text">
        password : <input type="password">
        <input type="submit" value="log in ">

    </form> <button href="<%= request.getContextPath()%>/registerServlet">register</button>
</div>
</body>
</html>
