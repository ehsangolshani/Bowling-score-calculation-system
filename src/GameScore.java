import java.util.ArrayList;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class GameScore {

    public int calcGameScore(Game game) {
        int totalScore = 0;
        if (game.isGameFinished()) {
            ArrayList<Frame> frames = game.getGameFrames();

            for (int i = 0; i < frames.size(); i++) {
                Frame frame = frames.get(i);
                switch (frame.frameStatus()) {
                    case MISS:
                        totalScore += frame.sumOfAttempts();
                        break;
                    case SPARE:
                        if (!game.isLastFrame(i)) totalScore += frame.sumOfAttempts() + calcSpareAward(game, i);
                        else totalScore += calcLastFrameScore(frame, game.getGameRule());
                        break;
                    case STRIKE:
                        if (!game.isLastFrame(i)) totalScore += frame.sumOfAttempts() + calcStrikeAward(game, i);
                        else totalScore += calcLastFrameScore(frame, game.getGameRule());
                        break;
                }
            }
        }
        return totalScore;
    }

    private int calcLastFrameScore(Frame frame, GameRule gameRule) {
        if (frame.rolls.size() == gameRule.getGamespec().getAttemptPerFrame()) {
            return frame.sumOfAttempts();
        } else {
            return 2 * frame.sumOfAttempts() - gameRule.getGamespec().getPinsNumber();
        }
    }

    private int calcStrikeAward(Game game, int index) {
        return game.calcAward(index, game.getGameRule().getStrikeAward());
    }

    private int calcSpareAward(Game game, int index) {
        return game.calcAward(index, game.getGameRule().getSpareAward());
    }

}
