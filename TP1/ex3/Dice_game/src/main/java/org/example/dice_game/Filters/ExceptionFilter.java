package org.example.dice_game.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import org.example.dice_game.models.Message;

import java.io.IOException;
import java.util.*;
@WebFilter("/*")
public class ExceptionFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("execption filter");
        try {
            chain.doFilter(request, response);
            System.out.println("no problem ");
        } catch (Exception e) {
            System.out.println("problem");
            List<Message> list = new ArrayList<>();
            list.add(new Message("Une erreur est survenue veuillez consulter le fichier journal pour plus de détails\n"+e.getLocalizedMessage(),
                    Message.ERROR));
            request.setAttribute("messages", list);
            getServletContext().getRequestDispatcher("/WEB-INF/Pages/error.jsp").forward(request, response);

        }
    }
}
