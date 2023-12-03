import java.util.Scanner;

public class Logic {
    public Logic() { }

    public void start() {
        System.out.println("Welcome! Before we get started, there's a custom mode where you can enter your own health, and there's a normal mode.");
        System.out.println("In normal mode, health is set to 100.");
        String userConfirm = "no";
        String userMode = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to play custom or normal?");
        userMode = scan.nextLine();
        if (userMode.equals("normal")) {
            while (userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no.")) {
                ProjectGame game = new ProjectGame("", 0);
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
        } else {
            while (userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no.")) {
                ProjectGame game = new ProjectGame("", 0, 100);
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
