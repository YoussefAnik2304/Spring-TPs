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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
    <div class="container w-50 bg-light d-flex justify-content-center mt-5 mb-5 rounded-5" style="height: 87%;">
        <div class="d-flex flex-column align-items-center justify-content-between" style="width: 90%">
            <nav class="alert alert-info navbar navbar-expand-lg navbar-light m-4 rounded-4" style="width: 100%">
                <div class="container-fluid">
                    <div class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Current Score</h5>
                        <span  id="current-score" style="font-weight:bold;font-size: 25px;">0</span>
                    </div>

                    <div class="d-flex flex-column align-items-center justify-content-between pt-2">
                        <a class="navbar-brand btn btn-outline-info bg-light mb-3" href="${pageContext.request.contextPath}/gameScores">Game Scores</a>
                        <div class="alert alert-danger p-1 m-0" style="color:red; font-weight:bold;font-size: 20px;">Rolls: <span id="roll-left">20</span></div>
                    </div>

                    <div class="d-flex flex-column align-items-center p-2">
                        <h5 style="font-weight:bold;font-size: 25px;">Best Score</h5>
                        <span id="best-score" style="font-weight:bold;font-size: 25px;">
                            ${requestScope.bestScore}
                        </span>
                    </div>
                </div>
            </nav>

            <div id="game-container" class="d-flex flex-column align-items-center justify-content-between bg-white rounded-5 pt-2 " style="width: 100%; height: 60%;">
                <div class="d-flex justify-content-between " style="width: 80%">
                    <div id="roll-1" class="bg-light nbr-container">-</div>
                    <div id="roll-2" class="bg-light nbr-container">-</div>
                    <div id="roll-3" class="bg-light nbr-container">-</div>
                    <div id="roll-4" class="bg-light nbr-container">-</div>
                    <div id="roll-5" class="bg-light nbr-container">-</div>
                </div>
                <div class="d-flex justify-content-between" style="width: 80%">
                    <div id="roll-6" class="bg-light nbr-container">-</div>
                    <div id="roll-7" class="bg-light nbr-container">-</div>
                    <div id="roll-8" class="bg-light nbr-container">-</div>
                    <div id="roll-9" class="bg-light nbr-container">-</div>
                    <div id="roll-10" class="bg-light nbr-container">-</div>
                </div>
                <div class="d-flex justify-content-between" style="width: 80%">
                    <div id="roll-11" class="bg-light nbr-container">-</div>
                    <div id="roll-12" class="bg-light nbr-container">-</div>
                    <div id="roll-13" class="bg-light nbr-container">-</div>
                    <div id="roll-14" class="bg-light nbr-container">-</div>
                    <div id="roll-15" class="bg-light nbr-container">-</div>
                </div>
                <div class="d-flex justify-content-between" style="width: 80%">
                    <div id="roll-16" class="bg-light nbr-container">-</div>
                    <div id="roll-17" class="bg-light nbr-container">-</div>
                    <div id="roll-18" class="bg-light nbr-container">-</div>
                    <div id="roll-19" class="bg-light nbr-container">-</div>
                    <div id="roll-20" class="bg-light nbr-container">-</div>
                </div>
                <div id="rollBtnContainer" class="m-0 p-0">
                    <button id="roll-btn" class="btn btn-outline-warning m-0" style="width: fit-content">Roll</button>
                </div>
                <form id="scoreForm" action="${pageContext.request.contextPath}/result" method="post">
                    <input id="scoreInput" type="hidden" value="" name ="score">
                </form>
            </div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" class="btn btn-outline-danger m-3">
            </form>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>