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
    <title>Game Scores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container w-50 bg-light d-flex justify-content-center mt-5 mb-5 rounded-5" style="height: 87%;">
        <div class="d-flex flex-column align-items-center justify-content-between" style="width: 100%">
            <nav class="alert alert-info navbar navbar-expand-lg navbar-light m-3 rounded-4" style="width: 100%">
                <div class="container-fluid">
                    <div id="current-score" class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Your Rank</h5>
                        <span style="font-weight:bold;font-size: 25px;"></span>
                    </div>

                    <a class="navbar-brand btn btn-outline-info bg-light" href="${pageContext.request.contextPath}/home">Start Game</a>

                    <div id="best-score" class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Your Best Score</h5>
                        <span style="font-weight:bold;font-size: 25px;">${requestScope.bestScore}</span>
                    </div>
                </div>
            </nav>

            <div class="d-flex flex-column bg-white rounded-5 p-4" style="width: 100%">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Username</th>
                        <th scope="col">Best Score</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="entry" items="${requestScope.playerMap}" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index + 1}</th>
                            <td>${entry.key}</td>
                            <td>${entry.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!--this loop is just for test-->
                <forEach var="item" items="${requestScope.testList}">
                    ${item}
                </forEach>

            </div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" class="btn btn-outline-danger m-3">
            </form>
        </div>
    </div>
</body>
</html>
