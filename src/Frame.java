import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Frame {

    private int awardNumbers;
    public List<Roll> rolls = new ArrayList<>();
    RuleSpec ruleSpec;

    public Frame(RuleSpec ruleSpec) {
        this.ruleSpec = ruleSpec;
    }

    protected boolean haveStrike() {
        return rolls.get(0).haveStrike();
    }

    protected boolean haveSpare() {
        return rolls.size() > 1 && sumOfAttempts() >= ruleSpec.getPinsNumber() && !haveStrike();
    }

    protected boolean canHaveAttempt() {
        return rolls.size() < ruleSpec.getAttemptPerFrame();
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

    protected ResultType addRoll(int hit) {
        rolls.add(new Roll(ruleSpec, hit));
        return frameStatus();
    }

    protected boolean haveAwards() {
        return awardNumbers > 0;
    }

    protected void decrementAward() {
        this.awardNumbers--;
    }

    protected void setAwardNumbers(int awardNumbers) {
        this.awardNumbers = awardNumbers;
    }

}
