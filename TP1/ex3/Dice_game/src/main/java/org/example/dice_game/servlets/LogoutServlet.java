package org.example.dice_game.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "login out ",urlPatterns = "/logOut")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalider la session
        request.getSession().invalidate();

        // On redirige vers login
        getServletContext().getRequestDispatcher("/WEB-INF/Pages/loginForm.jsp").forward(request, response);

        return;
    }

}
