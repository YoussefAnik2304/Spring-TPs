package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {

    public void addPlayer(Player player, ServletContext context) {
        Map<Player, Integer> players = (Map<Player, Integer>) context.getAttribute("players");
        if (players != null) {
            players.put(player, 0);
        } else {
            players = new HashMap<>();
            players.put(player, 0);
            context.setAttribute("players", players);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/signIn.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        String confirmedPassword = (String) req.getParameter("confirmedPassword");

        Player newPlayer = new Player(username, password);

        ServletContext context = getServletContext();
        addPlayer(newPlayer, context);
        
        req.setAttribute("successMsg", "Account created successfully");
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);


    }
}
