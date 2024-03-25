<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/3/2024
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="org.example.dice_game.models.Dice" %>
<%@ page import="org.example.dice_game.models.Game" %>
<%@ page import="org.example.dice_game.helpers.GameContextManagement" %>
<%@ page import="org.example.dice_game.models.Message" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>GameApp</title>
</head>
<body>
<header class="sticky">
    <div class="nes-container">
        <div class="nav-brand">
            <a href="">
                <h1>
                    <i class="snes-jp-logo brand-logo"></i>
                    Dice Game
                </h1>
            </a>

        </div>

    </div>
</header>
<% Game game = (Game) session.getAttribute("game");
    List<Dice> dices = game.getDices();
     List<Message> messages= (List<Message>) request.getAttribute("messages");

%>
<div class="nes-container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="<%= request.getContextPath() %>/Game" method="post">
                <div class="nes-field">
                    <label for="diceNumber">Dice number</label>
                    <input type="number" class="nes-input" id="diceNumber" name="diceNumber" min="1" max="3" placeholder="Enter dice number">
                </div>
                <br>
                <button type="submit" class="nes-btn is-primary" style="background-color: pink; padding: 10px 20px; font-size: 16px;" <%= game.getIsOver() ? "disabled" : "" %>>Roll</button>

            </form>
            <div class="mt-3">

                <% for (Dice dice : dices) { %>
                <p class="dice">
                    <%= (dice.getValue() == 0) ? "?" : dice.getValue() %>
                    <span class="badge badge-<%= (dice.isRolled()) ? "success" : "secondary" %>"><%= (dice.isRolled()) ? "Rolled" : "Not Rolled" %></span>
                </p>
                <% } %>
            </div>
            <section class="showcase">
                <section class="nes-container with-title">
                    <h3 class="title">Score</h3>
                    <p class="card-text">Current Score: <%= game.getPlayer().getScore() %></p>
                    <p class="card-text">Best Score: <%= game.getPlayer().getBestScore() %></p>
                </section>
            </section>

            <% if (game.getIsOver()) { %>
            <dialog class="nes-dialog" id="dialog-default">
                <form method="dialog">
                    <p class="title">Game Over !</p>
                    <% if (game.getIsWon()) { %>
                    <p>Game won GG's</p>
                    <% } else { %>
                    <ul>
                        <%
                            if (messages != null) {
                                for (Message m : messages) {
                        %>
                        <li style="color: red;"><%= m.getText() %></li>
                        <%
                            }
                        } else {
                        %>
                        <li>No messages available</li>
                        <%
                            }
                        %>
                    </ul>

                    <% } %>
                    <menu class="dialog-menu">
                        <button class="nes-btn">Cancel</button>
                        <button id="restart-button" class="nes-btn is-primary" >Restart</button>
                    </menu>
                </form>
            </dialog>
            <br>

            <% } %>
            <div style="display: flex; justify-content: space-between;">
                <form action="<%= request.getContextPath() %>/playerStats" method="post">
                    <button type="submit" class="nes-btn is-warning custom-btn">Best Score</button>
                </form>
                <form action="<%= request.getContextPath() %>/logOut" method="post">
                    <button type="submit" class="nes-btn is-error custom-btn">Disconnect</button>
                </form>
                <form action="<%= request.getContextPath() %>/reinit" method="post">
                    <button type="submit" class="nes-btn is-primary custom-btn">Restart</button>
                </form>
            </div>
        </div>
    </div>
    <ul>
        <%
            if (messages != null) {
                for (Message m : messages) {
        %>
        <li style="color: red;"><%= m.getText() %></li>
        <%
            }
        } else {
        %>
        <li>No messages available</li>
        <%
            }
        %>
    </ul>

</div>
</div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
    body {
        font-family: 'Press Start 2P', system-ui;
        font-weight: 400;
        font-style: normal;
    }
    .dice {
        font-size: 50px;
        text-align: center;
        color: #333;
        font-family: 'Courier New', Courier, monospace;
    }
    .badge {
        font-size: 30%;
        padding: .1em .2em;
        color: #fff;
        background-color: #007bff;
        border: 2px solid #333;
        border-radius: 5px;
    }

    .custom-btn {
        background-color: pink;
        padding: 10px 20px;
        font-size: 16px;
    }
    html, body {
        background-color: 	#FFF0F5;
        margin: 0;
        padding: 0;
        height: 100%;
    }

    .social-button {

        position: absolute;

        top: 10px;

        right: 30px;

    }
    .badge-success {
        background-color: #28a745;
    }
    .badge-secondary {
        background-color: #6c757d;
    }
    .card {
        width: 80%;
        margin: auto;
    }

    .card button {
        display: inline-block;
        margin-right: 10px;
    }

    @keyframes dice-roll {
        0% { transform: rotate(0deg); }
        50% { transform: rotate(180deg); }
        100% { transform: rotate(360deg); }
    }
</style>
<script>
    //display a dialog-default when the game ends
    var isGameOver = <%= game.getIsOver() %>;
    if (isGameOver) {
        document.getElementById('dialog-default').showModal();
    }
    //send a post request to our reinit servlet and refresh the page once the user clicks
    //on restart button
    var restartButton = document.getElementById('restart-button');
    if (restartButton) {
        restartButton.addEventListener('click', function() {
            fetch('<%= request.getContextPath() %>/reinit', { method: 'POST' })
                .then(response => {
                    window.location.href = '<%= request.getContextPath() %>/Game';
                })
        });
    }
</script>
</body>
</html>
