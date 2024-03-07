<%@ page import="com.example.ex2.Player" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Roll the Dice</title>
</head>
<body>
<h1>Roll the Dice Game</h1>

<form action="" method="post">
    <button type="submit">Roll the Dice</button>
</form>

<%
    Player player= (Player) session.getAttribute("logedInPlayer");
    // Check if the form is submitted
    int prv=0;
    int diceValue=0;
    if (request.getMethod().equals("POST")) {
        // Generate a random number between 1 and 6
        diceValue = (int) (Math.random() * 6) + 1;
%>
<p>You rolled: <%= diceValue %></p>
<%
    }
    if(prv==diceValue){
        player.setScore(player.getScore()+1);
    }
%>
</body>
</html>
