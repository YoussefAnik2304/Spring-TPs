package org.example.dice_game.Listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.dice_game.models.player;

import java.util.*;
@WebListener
public class ApplicationInitializer implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        List<player> players = Collections.synchronizedList(new ArrayList<player>());
        ctx.setAttribute("Players", players);
    }

}
