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
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        Player player = new Player(username, password);
        //verify the existance in the context else redirect with errors
        ServletContext context = getServletContext();
        Map<Player, Integer> players = (Map<Player, Integer>) context.getAttribute("players");

        if(players != null && players.containsKey(player)){
            //save in session
            HttpSession session = req.getSession();
            session.setAttribute("currentPlayer", player);
            session.setAttribute("currentPlayerScore", players.get(player));

            resp.sendRedirect(req.getContextPath()+"/home");
        }else{
            req.setAttribute("errorMsg", "Incorrect informations");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
        }

    }
}
