/**
 * Created by ehsangolshani on 10/9/16.
 */
public class PlayTest {
    public static void main(String[] args) {
        Rule rule = new Rule(new RuleSpec(10, 2), 2, 1, 10);
        GameScore gameScore = new GameScore();
        Game game = new Game(rule);
        Input input = new Input();
        Output output = new Output();
        input.consoleInput(game);
        output.consolePreview(game, gameScore);
    }
}
