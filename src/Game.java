import java.util.ArrayList;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Game {

    private ArrayList<Frame> gameFrames = new ArrayList<>();
    private Rule rule;
    private boolean gameFinished;

    public Game(Rule rule) {
        this.rule = rule;
        gameFrames.add(new Frame(rule.getGamespec()));
    }

    protected boolean isLastFrame(int index) {
        return index == rule.getMainFramesNumber() - 1;
    }

    private boolean isEndOfFrame(ResultType attemptResult, Frame currentFrame) {
        return (!currentFrame.canHaveAttempt() || attemptResult.equals(ResultType.SPARE) ||
                attemptResult.equals(ResultType.STRIKE));
    }

    private void handleEndOfFrame(Frame frame, ResultType attemptResult) {
        if (isEndOfFrame(attemptResult, frame)) {
            if (!isLastFrame(gameFrames.indexOf(frame))) {
                goToNextFrame();
            } else if (!frame.haveAwards()) {
                if (frame.haveStrike()) frame.setAwardNumbers(rule.getStrikeAward());
                else if (frame.haveSpare()) frame.setAwardNumbers(rule.getSpareAward());
                else finishGame();
            } else {
                frame.decrementAward();
                if (!frame.haveAwards()) finishGame();
            }
        }
    }

    private void goToNextFrame() {
        gameFrames.add(new Frame(rule.getGamespec()));
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

    protected void finishGame() {
        this.gameFinished = true;
    }

    protected int calcAward(int index, int limit) {
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

    protected ArrayList<Frame> getGameFrames() {
        return gameFrames;
    }

    protected Rule getRule() {
        return rule;
    }

}
