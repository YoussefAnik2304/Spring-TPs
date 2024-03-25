package org.example.dice_game.models;

public class player {

    private static int nbr_players=0;
    private String login;

    private String password;

    private int score;

    private int bestScore;

    public player( String login, String password, int score, int bestScore) {

        this.login = login;
        this.password = password;
        this.score = score;
        this.bestScore = bestScore;
        nbr_players++;
    }

    public static int getNbr_players() {
        return nbr_players;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
}
