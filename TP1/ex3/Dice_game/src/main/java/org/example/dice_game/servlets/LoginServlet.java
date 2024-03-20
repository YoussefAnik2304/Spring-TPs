package org.example.dice_game.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dice_game.models.player;

import java.util.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/Pages/loginForm.jsp").forward(req,resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login post");
        ServletContext context=req.getServletContext();
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        HttpSession session =req.getSession();
        List<player> players= (List<player>) context.getAttribute("Players");

         if(players.isEmpty()){
            context.getRequestDispatcher("/WEB-INF/Pages/registerForm.jsp").forward(req,resp);
            System.out.println("players is empty");
        }else{
            for (player p : players){
                if(p.getLogin().equalsIgnoreCase(login)){
                    session.setAttribute("logedInPlayer",p);
                    context.getRequestDispatcher("/WEB-INF/back/game.jsp").forward(req,resp);
                    return ;
                }
            }
            context.getRequestDispatcher("/WEB-INF/Pages/loginForm.jsp").forward(req,resp);
            System.out.println("account not registered");
        }

    }
}
