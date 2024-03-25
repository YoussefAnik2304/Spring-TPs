package org.example.dice_game.helpers;


import jakarta.servlet.ServletContext;
import org.example.dice_game.models.player;

import java.util.List;
import java.util.Optional;

public class GameContextManagement {

    private ServletContext context;

    public static GameContextManagement instance;

    private GameContextManagement(ServletContext context) {
        this.context = context;
    }

    synchronized public static final GameContextManagement getInstance(ServletContext context){
        if (instance == null) {
            instance = new GameContextManagement(context);
        }
        return instance;
    }
    public List<player> retrieveUsers(){
        return (List<player>) context.getAttribute("Players");
    }

    public Optional<player> isFound(String username){
        List<player> players = retrieveUsers();
        return players.stream().filter(user -> user.getLogin().equals(username)).findFirst();
    }



    public void updatePlayer(String username, int bestScore){
        List<player> players= retrieveUsers();
        for(player user : players){
            if(user.getLogin().equals(username)){
                user.setBestScore(bestScore);
            }
        }
    }


    public void addUser(player user){
        List<player> players= retrieveUsers();
        players.add(user);
        System.out.println(user);
    }





}


