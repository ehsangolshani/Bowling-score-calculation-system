import java.util.ArrayList;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class GameOutput {

    public void consolePreview(Game game, GameScore scoreHandler) {
        for (Frame frame : game.getGameFrames()) {
            System.out.println(previewFrame(frame));
        }

        System.out.println("total score :  " + scoreHandler.calcGameScore(game));
    }

    public String previewFrame(Frame frame) {
        String frameString = "";
        for (Roll roll : frame.rolls) {
            frameString += (roll.getPins() + "    ");
        }
        return frameString;
    }

}
