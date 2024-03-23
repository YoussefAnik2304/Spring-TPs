package servlet;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Player;

import java.io.IOException;
import java.util.Map;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get best score and set it in request
        HttpSession session = req.getSession();
        Player currentPlayer = (Player) session.getAttribute("currentPlayer");
        ServletContext context = getServletContext();
        Map<Player, Integer> players = (Map<Player, Integer>) context.getAttribute("players");
        Integer bestScore = players.get(currentPlayer);
        req.setAttribute("bestScore", bestScore);

        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,resp);
    }

}
