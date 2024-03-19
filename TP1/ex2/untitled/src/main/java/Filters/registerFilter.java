package com.example.ex2;

import com.example.ex2.Player;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;
import java.util.ArrayList;
@WebFilter("/registerServlet")
public class registerFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        ServletContext context=request.getServletContext();

        ArrayList<Player> players = (ArrayList<Player>) context.getAttribute("Players");
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        Player player=new Player(username,password,0);
        if(players!=null){
            if (player != null) {
                for (Player tmp : players) {
                    if (player.getUsername().equals(tmp.getUsername())) {
                        System.out.println("player alreay exists ");
                        req.getRequestDispatcher("/index.jsp").forward(req, res);
                        return;
                    }
                }
            } else {
                System.out.println("valeur null");
                request.getRequestDispatcher("/index.jsp").forward(req, res);
                return;
            }
        }else{
            players=new ArrayList<>();
            context.setAttribute("Players",players);
        }
        chain.doFilter(req,res);
    }
}
