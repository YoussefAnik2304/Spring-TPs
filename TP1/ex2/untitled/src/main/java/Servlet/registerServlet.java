package Servlet;

import Model.Player;
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
        System.out.println("doget");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=req.getServletContext();

        ArrayList<Player> players = (ArrayList<Player>) context.getAttribute("Players");
        String username=req.getParameter("username");
        String password =req.getParameter("password");
        Player player=new Player(username,password,0);
        if(players!=null){
            if (player != null) {
                for (Player tmp : players) {
                    if (player.getUsername().equals(tmp.getUsername())) {
                        System.out.println("player alreay exists ");
                        getServletContext().getRequestDispatcher("index.jsp").forward(req,resp);
                        return;
                    }
                }
            } else {
                System.out.println("valeur null");
                getServletContext().getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }
        }else{
            System.out.println("register filter ");
            players=new ArrayList<>();
            players.add(new Player(username,password,0));
            Player.setNbrPlayers(Player.getNbrPlayers()+1);
            context.setAttribute("Players",players);
        getServletContext().getRequestDispatcher("/WEB-INF/view/game.jsp").forward(req,resp);
        }
    }
}
