import java.util.Scanner;

public class Logic {
    public Logic () {
    }

    public void start() {
        System.out.println("Welcome! Before we get started, there's a custom mode where you can enter your own health, and there's a normal mode.");
        System.out.println("In normal mode, health is set to 100.");
        String userConfirm = "no";
        String userMode = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to play custom or normal? ");
        userMode = scan.nextLine();
        if (userMode.equals("normal")) {
            ProjectGame game = new ProjectGame("", 0);
            while (userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no.")) {
                System.out.print("Please enter your name: ");
                String name = scan.nextLine();
                game.setPlayerName(name);
                System.out.print("Enter the number of rounds: ");
                int rounds = scan.nextInt();
                game.setPlayerRound(rounds);
                game.setPlayerHealth();
                System.out.println(game.getInfo());
                System.out.print("Do you confirm this information? ");
                scan.nextLine();
                userConfirm = scan.nextLine();
            }
            System.out.println("Lastly, there are two elements to pick from: Light, and Dark.");
            System.out.print("Press 1 to select Light, or 2 to select Dark (this will not affect your power or give you any quirks, it's just customization) ");
            int input = scan.nextInt();
            game.elementSelect("Light, Dark", input);
            System.out.println("Your element has been set to " + game.getElement() + ".");
            System.out.println("Great! Starting game....");
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* New Game *~*~*~~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            // game logic starts here
            if (game.getElement().equals("Light")) {
                System.out.println("Rebellious beasts from the Dark Realm roam your hometown, terrorizing your family, friends, and people.");
                System.out.println("The Light Nation needs the help of an outstanding, brave citizen to yield the sword of Sun and eradicate these foul beasts.");
                System.out.println("They select you, " + game.getPlayerName() + ", to be that courageous soul.");
                System.out.println("So, do you have what it takes to liberate your land with nothing but your sword, shield, and wit?");
                System.out.println("Or will you succumb to defeat?");
                System.out.println("Time to find out.");
            } else {
                System.out.println("Evil, menacing beast warriors from the Light Realm have been devastating your mother land.");
                System.out.println("They called you a barbarian for being of the Dark, and slaughtered your family and loved ones when you were young.");
                System.out.println("It's time for revenge. You yield the spear of Moon and equip your shield, ready to take action.");
                System.out.println("So, " + game.getPlayerName() + ", will today be the day you raise your blood covered spear in victory over the vile dead bodies of your enemies?");
                System.out.println("Or, will you succumb to their treacherous torture and die shamefully?");
                System.out.println("Time to find out.");
            }
            int winCount = 0;
            for (int i = 1; i <= game.getRound(); i++) {
                System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~ Round " + i + " *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                System.out.println("A monster approaches with a health of 100!");
                int currentHealth = (int) game.getPlayerHealth();
                int monsterHealth = game.getMonsterHealth();
                while (currentHealth > 0 && monsterHealth > 0) {
                    System.out.print("Attack or shield? 1 for attack, 2 for shield. ");
                    int userMove = scan.nextInt();
                    int proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("You missed! Monster's turn!");
                    } else if (userMove == 1) {
                        int dmg = game.playerAttack();
                        monsterHealth -= dmg;
                        System.out.println("Successfully attacked Monster with " + dmg + " damage! Monster is now at " + monsterHealth + " health!");
                    }
                    if (monsterHealth > 0) {

                    }
                    System.out.println("-");
                    System.out.println("Monster makes a move!");
                    System.out.println("-");
                    proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("Monster missed!");
                    } else {
                        int dmg = game.monsterAttack();
                        currentHealth -= dmg;
                        System.out.println("Monster attacked with " + dmg + " damage! You are now at " + currentHealth + " heath!");
                        if (userMove == 2) {
                            currentHealth += (dmg/2);
                            int recoilChance = (int) ((Math.random() * 3) + 1);
                            if (recoilChance == 1) {
                                monsterHealth -= 5;
                                System.out.println("When you shielded, Monster faced 5 recoil damage and is now at " + monsterHealth + " health");
                            }
                            int bombChance = (int) ((Math.random() * 4) + 1);
                            if (bombChance == 1) {
                                monsterHealth -= 10;
                                System.out.println("Yikes! Monster stepped on a landmine! Monster faces 10 damage and is now at " + monsterHealth + " health");
                            }
                            System.out.println("You shielded yourself, so half health that was lost is now returned! You are now at " + currentHealth + " heath!");
                        }
                    }
                    currentHealth = game.bigLandMineChance(currentHealth);
                    monsterHealth = bigLandMineMonsterChance(monsterHealth);
                    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                    System.out.println("Your Current Health: " + currentHealth);
                    System.out.println("Monster's Current Health: " + monsterHealth);
                    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                }
                if (monsterHealth <= 0) {
                    winCount++;
                    System.out.println("GAME OVER! The monster was successfully slain. You win this round!");
                } else if (currentHealth <= 0) {
                    System.out.println("GAME OVER! You died this round!");
                } else {
                    System.out.println("You both died! Nobody wins!");
                }
            }
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~ Final Results ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            System.out.println("Out of " + game.getRound() + " rounds, you won " + winCount + " times!");
            if (winCount == 0) {
                System.out.println("Haha, skill issue, loser. I'm just joking! Better luck next time! :D");
            }
        } else { //custom mode is here
            ProjectGame game = new ProjectGame("", 0, 100);
            while (userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no.")) {
                System.out.print("Please enter your name: ");
                String name = scan.nextLine();
                game.setPlayerName(name);
                System.out.print("Enter the number of rounds: ");
                int rounds = scan.nextInt();
                game.setPlayerRound(rounds);
                System.out.print("Enter the health (lower than 100 for hard, higher than 100 for easy): ");
                int health = scan.nextInt();
                game.setPlayerHealth(health);
                System.out.println(game.getInfo());
                System.out.print("Do you confirm this information? ");
                scan.nextLine();
                userConfirm = scan.nextLine();
            }
            System.out.println("Great! Starting game....");
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* New Game *~*~*~~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            if (game.getElement().equals("Light")) {
                System.out.println("Rebellious beasts from the Dark Realm roam your hometown, terrorizing your family, friends, and people.");
                System.out.println("The Light Nation needs the help of an outstanding, brave citizen to yield the sword of Sun and eradicate these foul beasts");
                System.out.println("They select you, " + game.getPlayerName() + ", to be that courageous soul.");
                System.out.println("So, do you have what it takes to liberate your land with nothing but your sword, shield, and wit?");
                System.out.println("Or will you succumb to defeat?");
                System.out.println("Time to find out.");
            } else {
                System.out.println("Evil, menacing beast warriors from the Light Realm have been devastating your mother land.");
                System.out.println("They called you a barbarian for being of the Dark, and slaughtered your family and loved ones when you were young.");
                System.out.println("It's time for revenge. You yield the spear of Moon and equip your shield, ready to take action.");
                System.out.println("So, " + game.getPlayerName() + ", will today be the day you raise your blood covered spear in victory over the vile dead bodies of your enemies?");
                System.out.println("Or, will you succumb to their treacherous torture and die shamefully?");
                System.out.println("Time to find out.");
            }
            int winCount = 0;
            for (int i = 1; i <= game.getRound(); i++) {
                System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~ Round " + i + " *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                System.out.println("A monster approaches with a health of 100!");
                int currentHealth = (int) game.getPlayerHealth();
                int monsterHealth = game.getMonsterHealth();
                while (currentHealth > 0 && monsterHealth > 0) {
                    System.out.print("Attack or shield? 1 for attack, 2 for shield. ");
                    int userMove = scan.nextInt();
                    int proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("You missed! Monster's turn!");
                    } else if (userMove == 1) {
                        int dmg = game.playerAttack();
                        monsterHealth -= dmg;
                        System.out.println("Successfully attacked Monster with " + dmg + " damage! Monster is now at " + monsterHealth + " health!");
                    }
                    System.out.println("-");
                    System.out.println("Monster makes a move!");
                    System.out.println("-");
                    proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("Monster missed!");
                    } else {
                        int dmg = game.monsterAttack();
                        currentHealth -= dmg;
                        System.out.println("Monster attacked with " + dmg + " damage! You are now at " + currentHealth + " heath!");
                        if (userMove == 2) {
                            currentHealth += (dmg/2);
                            int recoilChance = (int) ((Math.random() * 3) + 1);
                            if (recoilChance == 1) {
                                monsterHealth -= 5;
                                System.out.println("When you shielded, Monster faced 5 recoil damage and is now at " + monsterHealth + " health");
                            }
                            int bombChance = (int) ((Math.random() * 4) + 1);
                            if (bombChance == 1) {
                                monsterHealth -= 10;
                                System.out.println("Yikes! Monster stepped on a landmine! Monster faces 10 damage and is now at " + monsterHealth + " health");
                            }
                            System.out.println("You shielded yourself, so half health that was lost is now returned! You are now at " + currentHealth + " heath!");
                        }
                    }
                    currentHealth = game.bigLandMineChance(currentHealth);
                    monsterHealth = bigLandMineMonsterChance(monsterHealth);
                    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                    System.out.println("Your Current Health: " + currentHealth);
                    System.out.println("Monster's Current Health: " + monsterHealth);
                    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                }
                if (monsterHealth < currentHealth) {
                    winCount++;
                    System.out.println("GAME OVER! The monster was successfully slain. You win this round!");
                } else if (currentHealth < monsterHealth) {
                    System.out.println("GAME OVER! You died this round!");
                } else {
                    System.out.println("You both died! Nobody wins! (dang yall suck)");
                }
            }
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~ Final Results ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            System.out.println("Out of " + game.getRound() + " rounds, you won " + winCount + " times!");
            if (winCount == 0) {
                System.out.println("Haha, skill issue, loser. I'm just joking! Better luck next time! :D");
            }
        }
    }

    private int bigLandMineMonsterChance (int stat) {
        int bigBombChance = (int) ((Math.random() * 10) + 1);
        if (bigBombChance == 1) {
            stat -= 20;
            System.out.println("Look! The monster stepped on a HUGE LANDMINE! The monster faces 20 damage!");
        }
        return stat;
    }
}

// this was very painful in case you're wondering.