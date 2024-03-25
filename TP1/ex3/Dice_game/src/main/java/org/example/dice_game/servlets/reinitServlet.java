package org.example.dice_game.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.example.dice_game.models.Game;

import java.io.IOException;

@WebServlet("/reinit")
public class reinitServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = (Game)request.getSession().getAttribute("game");
        game.reinit();
        getServletContext().getRequestDispatcher("/WEB-INF/back/game.jsp").forward(request,response);
    }

}
