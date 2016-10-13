import java.util.Scanner;

/**
 * Created by ehsangolshani on 10/10/16.
 */
public class GameInput {

    Scanner scanner;

    public void consoleInput(Game game) {
        scanner = new Scanner(System.in);
        System.out.println("hey, throw ball !");
        System.out.println("finish game with entering a non-numerical character !");
        while (scanner.hasNextInt()) {
            game.attempt(scanner.nextInt());
        }
    }

    public void fileInput(Game game) {

    }

}
