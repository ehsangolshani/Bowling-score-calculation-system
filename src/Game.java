import java.util.ArrayList;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Game {

    private ArrayList<Frame> gameFrames = new ArrayList<>();
    private GameRule gameRule;
    private boolean gameFinished;

    public Game(GameRule gameRule) {
        this.gameRule = gameRule;
        gameFrames.add(new Frame(gameRule.getGamespec()));
    }

    protected boolean isLastFrame() {
        return gameFrames.size() == gameRule.getMainFramesNumber();
    }

    protected boolean isLastFrame(int index) {
        return index == gameRule.getMainFramesNumber() - 1;
    }

    protected void goToNextFrame() {
        gameFrames.add(new Frame(gameRule.getGamespec()));
    }

    protected boolean haveSpareOrStrike(ResultType attemptResult) {
        return attemptResult.equals(ResultType.SPARE) ||
                attemptResult.equals(ResultType.STRIKE);
    }

    protected boolean isEndOfFrame(ResultType attemptResult, Frame currentFrame) {
        return (!currentFrame.canHaveAttempt() || haveSpareOrStrike(attemptResult));
    }

    private void handleEndOfFrame(Frame frame, ResultType attemptResult) {
        if (isEndOfFrame(attemptResult, frame)) {
            if (!isLastFrame()) {
                goToNextFrame();
            } else if (!frame.haveAwards()) {
                if (frame.haveStrike()) frame.setAwardNumbers(gameRule.getStrikeAward());
                else if (frame.haveSpare()) frame.setAwardNumbers(gameRule.getSpareAward());
                else finishGame();
            } else {
                frame.decrementAward();
                if (!frame.haveAwards()) finishGame();
            }
        }
    }

    protected ResultType attempt(int hit) {
        ResultType attemptResult = null;
        if (!isGameFinished()) {
            Frame currentFrame = gameFrames.get(gameFrames.size() - 1);
            attemptResult = currentFrame.addRoll(hit);
            handleEndOfFrame(currentFrame, attemptResult);
        }
        return attemptResult;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void finishGame() {
        this.gameFinished = true;
    }

    public int calcAward(int index, int limit) {
        int counter = 0;
        int award = 0;

        for (int i = index + 1; i < gameFrames.size() && counter < limit; i++) {
            Frame tempFrame = gameFrames.get(i);
            for (int j = 0; j < tempFrame.rolls.size() && counter < limit; j++, counter++) {
                Roll tempRoll = tempFrame.rolls.get(j);
                award += tempRoll.getPins();
            }
        }
        return award;
    }

    public ArrayList<Frame> getGameFrames() {
        return gameFrames;
    }


    public GameRule getGameRule() {
        return gameRule;
    }

}
