<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>
<div class="register">
    <form action="/registerServlet" method="post">
        username : <input type="text" name="username">
        password : <input type="password" name="password">
        <input type="submit" value="register">
    </form>
</div>
</body>
</html>