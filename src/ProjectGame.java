public class ProjectGame {
    private String playerName;
    private int playerRound;
    private double playerHealth;
    private int monsterHealth;
    private String element;
    public ProjectGame (String playerName, int playerRound, double playerHealth) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = playerHealth;
        this.monsterHealth = 100;
        this.element = "";
    }

    public ProjectGame (String playerName, int playerRound) {
        this.playerName = playerName;
        this.playerRound = playerRound;
        this.playerHealth = 0;
        this.monsterHealth = 100;
        this.element = "";
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

    public String getPlayerName () {
        return playerName;
    }

    public int getRound () {
        return playerRound;
    }

    public double getPlayerHealth () {
        return playerHealth;
    }

    public int getMonsterHealth () {
        return monsterHealth;
    }

    public String getElement () {
        return element;
    }

    public int playerAttack () {
        int attackAmount = (int) ((Math.random() * 10) + 1); // range from 1 to 10
        return attackAmount;
    }

    public int monsterAttack () {
        int attackAmount = (int) ((Math.random() * 10) + 1); // range from 1 to 10
        return attackAmount;
    }

    public int bigLandMineChance (int stat) {
        int bigBombChance = (int) ((Math.random() * 10) + 1);
        if (bigBombChance == 1) {
            stat -= 20;
            System.out.println("Uh oh! A HUGE LANDMINE WENT OFF!! You face 20 damage!");
        }
        return stat;
    }

    public void elementSelect (String str, int input) { // The string will be entered with 2 words, and a comma and space between those two words. ex: "Ice, Fire"
        int commaIndex = str.indexOf(",");
        if (input == 1) {
            element = str.substring(0, commaIndex);
        } else {
            element = str.substring(commaIndex+2);
        }
    }
}
