package com.example.ex2;

import com.example.ex2.Player;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
@WebFilter("/loginServlet")
public class loginFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String username=request.getParameter("username");
        String password =req.getParameter("password");
        HttpSession session =request.getSession() ;

        ServletContext context=req.getServletContext();
        ArrayList<Player> players = (ArrayList<Player>) context.getAttribute("Players");

        if(players!=null){
            for (Player tmp : players ){
                System.out.println(tmp.getUsername()+" "+tmp.getPassword());
                if(tmp.getUsername().equals(username)) {
                    System.out.println("player found ");
                    if (tmp.getPassword().equals(password)) {
                        Player player = new Player(username, password, tmp.getScore());
                        session.setAttribute("logedInPlayer", player);
                    } else {
                        System.out.println("password wrong");
                        request.getRequestDispatcher("/index.jsp").forward(req, res);
                        return;
                    }
                }
            }
        }else {
            System.out.println("no players found ");
            request.getRequestDispatcher("/register.jsp").forward(req,res);
            return ;
        }
        chain.doFilter(req, res);
    }
}
