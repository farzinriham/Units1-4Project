public class ProjectGame {
    private String playerName;
    private int playerRound;
    private double playerHealth;
    private int monsterHealth;
    public ProjectGame (String playerName, int playerRound, double playerHealth) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = playerHealth;
        this.monsterHealth = 100;
    }

    public ProjectGame (String playerName, int playerRound) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = 0;
        this.monsterHealth = 100;
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

    public int getRound () {
        return playerRound;
    }

    public double getPlayerHealth () {
        return playerHealth;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public int playerAttack () {
        int attackAmount = (int) ((Math.random() * 10) + 1); // range from 1 to 10
        return attackAmount;
    }

    public int monsterAttack () {
        int attackAmount = (int) ((Math.random() * 10) + 1); // range from 1 to 10
        return attackAmount;
    }
}
