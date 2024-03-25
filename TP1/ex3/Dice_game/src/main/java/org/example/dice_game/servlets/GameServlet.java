package org.example.dice_game.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dice_game.helpers.GameContextManagement;
import org.example.dice_game.models.Game;
import org.example.dice_game.models.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Game")
public class GameServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Game game = (Game) request.getSession().getAttribute("game");
        game.reinit();
        getServletContext().getRequestDispatcher("/WEB-INF/back/game.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Retrieve number of dice and generate value back
        int diceNumber = Integer.parseInt(request.getParameter("diceNumber"));
        System.out.println("dice number : " + diceNumber);
        List<Message> messageList = new ArrayList<>();

        GameContextManagement ctx = GameContextManagement.getInstance(getServletContext());

        boolean sixvalued = false;

        //retrieve the game from the session
        Game game = (Game) request.getSession().getAttribute("game");
        //check if game is not over yet !
        if(!game.getIsOver()) {
            //check if the dice is already rolled or not
            if (!game.isRolled(diceNumber)) {
                //roll the dice corresponding to the choice
                game.rollDice(diceNumber);
                //check if any of the first and second dice rolled a 6 value -> Game over !
                sixvalued = game.sixValued();
                //check if the dices values are in ascending order if not -> Game over !
                game.AreDicesInAscendingOrder();
            } else {
                //if the dice is arleady rolled -> score  -1 !
                Message message = new Message("Dice already rolled -> Game over !  ",Message.INFO);
                messageList.add(message);
                //set the Player score to -1 !
                game.getPlayer().setScore(-1);
                //set the game over to true !
                game.setOver(true);
                request.setAttribute("messages", messageList);
            }
            if(sixvalued){
                Message message = new Message("6 rolled -> Game over !",Message.INFO);
                messageList.add(message);
                request.setAttribute("messages", messageList);
            }
        }
        //if all the dices are rolled and the game is won -> Dices values are in ascending order
        if(game.Allrolled() && game.getIsWon()){
            //set the score to the sum of value of dices
            game.getPlayer().setScore(game.sumScore());
            //check if the score of the Player is bigger than best score
            if(game.getPlayer().getBestScore() < game.getPlayer().getScore()){
                game.getPlayer().setBestScore(game.getPlayer().getScore());
            }
            //update the Player infos in our context
            ctx.updatePlayer(game.getPlayer().getLogin(), game.getPlayer().getBestScore());
            //set the game over to true
            game.setOver(true);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/back/game.jsp").forward(request,response);
    }
}