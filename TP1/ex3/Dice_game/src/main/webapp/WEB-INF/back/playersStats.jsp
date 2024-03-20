<%@ page import="org.example.dice_game.models.player" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sun.net.httpserver.HttpContext" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/20/2024
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Players Statistics</title>
    <style>
        /* Style for the table */
        table {
            width: 60%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        /* Style for table headers */
        th {
            background-color: #f2f2f2;
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        /* Alternate row background color */
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Style for table data cells */
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        /* Style for the "No players" message */
        .no-players {
            font-style: italic;
            color: #666;
        }
        .container{
            display :flex;
            align-items: center;
            justify-content: center;

        }
    </style>
</head>
<body>
<h2>Number of Players : <%= player.getNbr_players()%></h2>
<div class="container">
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Best Score</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<player> players = (List<player>) request.getServletContext().getAttribute("Players");
        if (players != null && !players.isEmpty()) {
            for (player p : players) {
    %>
    <tr>
        <td><%= p.getLogin()%></td>
        <td><%= p.getBestScore()%></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2" class="no-players">No players</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
