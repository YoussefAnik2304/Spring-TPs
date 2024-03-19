package org.example.dice_game.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dice_game.models.player;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registerServlet" ,urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/Pages/registerForm.jsp").forward(req,resp);
        System.out.println("register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("register post ");
        ServletContext context=req.getServletContext();
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        HttpSession session =req.getSession();
        List<player> players= (List<player>) context.getAttribute("Players");
        player newPlayer=new player(login,password,0,0);
        for (player p : players){
            if(p.getLogin().equalsIgnoreCase(login)){
                System.out.println("already exists ");
                context.getRequestDispatcher("/WEB-INF/Pages/loginForm.jsp").forward(req,resp);
                return ;
            }
        }
        players.add(newPlayer);
        context.setAttribute("Players",players);
        session.setAttribute("logedInPlayer",newPlayer);
        context.getRequestDispatcher("/WEB-INF/back/game.jsp").forward(req,resp);
    }

}
