public class ProjectGame {
    private String playerName;
    private int playerRound;
    private double playerHealth;
    public ProjectGame (String playerName, int playerRound, double playerHealth) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = playerHealth;
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
        return "Player Name: " + playerName + "\nPlayer Health: " + playerHealth + "\nCurrent Round: " + playerRound;
    }

    private int getRound () {
        return playerRound;
    }


}
