import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        String userConfirm = "no";
        while (userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no.")) {
            Scanner scan = new Scanner(System.in);
            ProjectGame game = new ProjectGame("", 0, 100);
            System.out.print("Please enter your name: ");
            String name = scan.nextLine();
            game.setPlayerName(name);
            System.out.println(game.getInfo());
            System.out.print("Do you confirm this information? ");
            userConfirm = scan.nextLine();
            if (!(userConfirm.equals("no") || userConfirm.equals("No") || userConfirm.equals("No.") || userConfirm.equals("no."))) {
                System.out.println("Great! Starting game....");
            }
        }
    }
}
