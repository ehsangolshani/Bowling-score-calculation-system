import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Frame {

    private int awardNumbers;
    public List<Roll> rolls = new ArrayList<>();
    GameRuleSpec gameRuleSpec;

    public Frame(GameRuleSpec gameRuleSpec) {
        this.gameRuleSpec = gameRuleSpec;
    }

    protected boolean haveStrike() {
        return rolls.get(0).haveStrike();
    }

    protected boolean haveSpare() {
        return rolls.size() > 1 && sumOfAttempts() >= gameRuleSpec.getPinsNumber();
    }

    protected boolean canHaveAttempt() {
        return rolls.size() < gameRuleSpec.getAttemptPerFrame();
    }

    protected ResultType frameStatus() {
        if (haveSpare()) return ResultType.SPARE;
        else if (haveStrike()) return ResultType.STRIKE;
        else return ResultType.MISS;
    }

    protected int sumOfAttempts() {
        int sum = 0;
        for (Roll roll : rolls) sum += roll.getPins();
        return sum;
    }

    protected boolean haveAwards() {
        return awardNumbers > 0;
    }

    protected ResultType addRoll(int hit) {
        rolls.add(new Roll(gameRuleSpec, hit));
        return frameStatus();
    }

    public void decrementAward() {
        this.awardNumbers--;
    }

    public void setAwardNumbers(int awardNumbers) {
        this.awardNumbers = awardNumbers;
    }

}
