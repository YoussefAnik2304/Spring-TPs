<%--
  Created by IntelliJ IDEA.
  User: Haitham
  Date: 2/29/2024
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container w-50 bg-light d-flex justify-content-center mt-5 mb-5 rounded-5" style="height: 87%;">
        <div class="d-flex flex-column align-items-center p-5">
            <!-- account created msg-->
            <c:if test="${not empty requestScope.successMsg}">
                <div class="alert alert-success p-2">
                    ${requestScope.successMsg}
                </div>
            </c:if>
            <!-- incorrect info msg-->
            <c:if test="${not empty requestScope.errorMsg}">
                <div class="alert alert-danger p-2">
                    ${requestScope.errorMsg}
                </div>
            </c:if>
            <h1 class="p-5" style="font-weight:900;font-size: 50px;">Login</h1>
            <div class="d-flex flex-column bg-white rounded-5 p-5 ">
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="username" name="username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
