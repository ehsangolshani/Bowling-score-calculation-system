import java.util.Scanner;

/**
 * Created by ehsangolshani on 10/10/16.
 */
public class Input {

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public void consoleInput(Game game) {
        System.out.println("hey, throw ball !");
        System.out.println("finish game with entering a non-numerical character !");
        while (scanner.hasNextInt() && !game.isGameFinished()) {
            game.attempt(scanner.nextInt());
        }
    }

}
