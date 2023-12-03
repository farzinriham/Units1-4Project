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
        System.out.print("Would you like to play custom or normal?");
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
            System.out.println("Great! Starting game....");
            System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
            // game logic starts here
            System.out.println("Beasts roam your hometown, terrorizing your family, friends, and people.");
            System.out.println("Your people select you as their hero, to help save this town.");
            System.out.println("Will you liberate them with your sword or fall to defeat? Time to find out.");
            for (int i = 1; i <= game.getRound(); i++) {
                System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~ New Game ~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                System.out.println("A monster approaches with a health of 100!");
                int currentHealth = (int) game.getPlayerHealth();
                int monsterHealth = game.getMonsterHealth();
                while (currentHealth > 0 && monsterHealth > 0) {
                    System.out.print("Attack or shield? 1 for attack, 2 for shield.");
                    int userMove = scan.nextInt();
                    int proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("You missed! Monster's turn!");
                    } else if (userMove == 1) {
                        int dmg = game.playerAttack();
                        monsterHealth -= dmg;
                        System.out.println("Successfully attacked Monster with " + dmg + " damage! Monster is now at " + monsterHealth + " health!");
                    }
                    System.out.println("Monster makes a move!");
                    proceed = (int) ((Math.random() * 3) + 1);
                    if (proceed == 3) {
                        System.out.println("Monster missed!");
                    } else {
                        int dmg = game.monsterAttack();
                        currentHealth -= dmg;
                        System.out.println("Monster attacked with " + dmg + " damage! You are now at " + currentHealth + " heath!");
                        if (userMove == 2) {
                            currentHealth += (dmg/2);
                            int bombChance = (int) ((Math.random() * 4) + 1);
                            if (bombChance == 1) {
                                monsterHealth -= 10;
                                System.out.println("Yikes! Monster stepped on a landmine! Monster faces 10 damage and is now at " + monsterHealth + " health");
                            }
                            System.out.println("You shielded yourself, so half health that was lost is now returned! You are now at " + currentHealth + " heath!");
                        }
                    }
                    System.out.println("Your Current Health: " + currentHealth);
                    System.out.println("Monster's Current Health: " + monsterHealth);
                }
            }
            //custom mode is here
        } else {
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
        }
    }
}
