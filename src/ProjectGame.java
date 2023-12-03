public class ProjectGame {
    private String playerName;
    private int playerRound;
    private double playerHealth;
    public ProjectGame (String playerName, int playerRound, double playerHealth) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = playerHealth;
    }

    public ProjectGame (String playerName, int playerRound) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = 0;
    }

    public void setPlayerHealth (int health) {
        playerHealth = health;
    }

    public void setPlayerHealth () {
        playerHealth = 100;
    }

    public void setPlayerName (String name) {
        playerName = name;
    }

    public void setPlayerRound (int round) {
        playerRound = round;
    }

    public String getInfo () {
        return "Player Name: " + playerName + "\nPlayer Health: " + playerHealth + "\nSelected Number of Rounds: " + playerRound;
    }

    private int getRound () {
        return playerRound;
    }


}
