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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

@WebServlet("/gameScores")
public class Scores extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Player currentPlayer = (Player) session.getAttribute("currentPlayer");
        ServletContext context = getServletContext();
        Map<Player, Integer> players = (Map<Player, Integer>) context.getAttribute("players");
        Integer bestScore = players.get(currentPlayer);


        Map<String, Integer> playersInfos = new HashMap<>();
        for (Map.Entry<Player, Integer> entry : players.entrySet()) {
            Player key = entry.getKey();
            Integer sc = entry.getValue();
            playersInfos.put(key.getUsername(), sc);
            System.out.printf(key.getUsername() + sc);
        }

        //req.setAttribute("playerRank", playerRank);
        req.setAttribute("bestScore", bestScore);
        req.setAttribute("playerMap", playersInfos);
        LinkedList<String> testList = new LinkedList<>();
        testList.add("eee");testList.add("rrrrrr");
        req.setAttribute("playerMap", playersInfos);
        req.setAttribute("testList", testList);

        req.getRequestDispatcher("/WEB-INF/view/scores.jsp").forward(req,resp);
    }
}
