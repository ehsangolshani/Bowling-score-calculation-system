/**
 * Created by ehsangolshani on 10/9/16.
 */
public class PlayTest {
    public static void main(String[] args) {
        GameRule rule = new GameRule(new GameRuleSpec(10, 2), 2, 1, 10);
        GameScore gameScore = new GameScore();
        Game game = new Game(rule);
        GameInput input = new GameInput();
        GameOutput output = new GameOutput();
        input.consoleInput(game);
        output.consolePreview(game, gameScore);
    }
}
