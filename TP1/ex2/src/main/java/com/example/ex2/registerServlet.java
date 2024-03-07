package com.example.ex2;

import com.example.ex2.Player;
import com.sun.net.httpserver.HttpContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=req.getServletContext();
        ArrayList<Player> players = (ArrayList<Player>) context.getAttribute("Players");
        String username=req.getParameter("username");
        String password =req.getParameter("password");
        players.add(new Player(username,password,0));
        Player.setNbrPlayers(Player.getNbrPlayers()+1);
        context.setAttribute("Players",players);
        req.getRequestDispatcher("/game.jsp").forward(req,resp);
    }
}
