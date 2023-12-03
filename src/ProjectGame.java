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
        int powerUp = (int) ((Math.random() * 3) + 1);
        int powerUpDmg = 0;
        if (powerUp == 1) {
            System.out.println("You collected an attack power up!");
            powerUpDmg = (int) ((Math.random() * 5) + 11);
        }
        int specialAttack = (int) ((Math.random() * 7) + 1);
        if (specialAttack == 1) {
            if (element.equals("Light")) {
                attackAmount = 25;
                System.out.println("SUN RAY ACTIVATED! Your Sun Sword charged up and fired a beam of 20 damage right at the beast, along with your additional previous attack!");
            } if (element.equals("Dark")) {
                attackAmount = 25;
                System.out.println("CRESCENT BEAM ACTIVATED! Your Moon spear charged up and fired a beam of 20 damage right at the beast, along with your additional previous attack!");
            }
        }
        return attackAmount + powerUpDmg;
    }

    public int monsterAttack () {
        int attackAmount = (int) ((Math.random() * 15) + 1); // range from 1 to 10
        int powerUp = (int) ((Math.random() * 5) + 1);
        if (powerUp == 1) {
            System.out.println("The monster gained attack momentum!");
            attackAmount = (int) ((Math.random() * 10) + 16);
        }
        int uhOh = (int) ((Math.random() * 15) + 1);
        if (uhOh == 1) {
            int wholeNum = ((int) ((Math.random() * 3) + 6));
            attackAmount = (int) Math.pow(wholeNum, 2);
            System.out.println("What's this!......");
            System.out.println("MONSTER CHARGED A HUGE BLOW!");
            System.out.println("YIKES! YOU LOSE " + attackAmount + " HEALTH!");
        }
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
