package Model;

public class Player {
    private String username,password;
    private long score;
    private static int nbrPlayers=0;

    public Player(String username, String password, long score) {
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public static int getNbrPlayers() {
        return nbrPlayers;
    }

    public static void setNbrPlayers(int nbrPlayers) {
        Player.nbrPlayers = nbrPlayers;
    }


}
