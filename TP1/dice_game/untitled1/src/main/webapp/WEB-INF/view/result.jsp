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
    <title>result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container w-50 bg-light d-flex justify-content-center mt-5 mb-5 rounded-5" style="height: 87%;">
        <div class="d-flex flex-column align-items-center justify-content-between" style="width: 90%">
            <nav class="alert alert-info navbar navbar-expand-lg navbar-light m-4 rounded-4" style="width: 100%">
                <div class="container-fluid">
                    <div class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Current Score</h5>
                        <span  id="current-score" style="font-weight:bold;font-size: 25px;">
                                ${requestScope.currentScore}
                        </span>
                    </div>

                    <div class="d-flex flex-column align-items-center justify-content-between pt-2">
                        <a class="navbar-brand btn btn-outline-info bg-light mb-3" href="${pageContext.request.contextPath}/gameScores">Game Scores</a>
                    </div>

                    <div class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Best Score</h5>
                        <span id="best-score" style="font-weight:bold;font-size: 25px;">
                            ${requestScope.bestScore}
                        </span>
                    </div>
                </div>
            </nav>

            <div id="game-container" class="d-flex flex-column align-items-center justify-content-center bg-white rounded-5 p-4 " style="width: 100%; height: 60%;">
                <a href="${pageContext.request.contextPath}/home" style="text-decoration: none"><h3>Replay</h3></a>
                <a href="${pageContext.request.contextPath}/home" class=""><img src="${pageContext.request.contextPath}/img/restartIcon.png"></a>
            </div>

            <form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" class="btn btn-outline-danger m-3">
            </form>
        </div>
    </div>
</body>
</html>