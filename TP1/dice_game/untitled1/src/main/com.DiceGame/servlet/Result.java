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

@WebServlet("/result")
public class Result extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer currentScore = Integer.parseInt(req.getParameter("score"));

        HttpSession session = req.getSession();
        Player currentPlayer = (Player) session.getAttribute("currentPlayer");
        //get player from context and his score
        ServletContext context = getServletContext();
        Map<Player, Integer> players = (Map<Player, Integer>) context.getAttribute("players");
        Integer bestScore = players.get(currentPlayer);
        if(bestScore < currentScore){
            players.put(currentPlayer, currentScore);
        }

        req.setAttribute("bestScore", bestScore);
        req.setAttribute("currentScore", currentScore);
        req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req,resp);

    }
}
