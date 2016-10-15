/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Roll {

    private int rollPins;
    RuleSpec ruleSpec;

    public Roll(RuleSpec ruleSpec, int rollPins) {
        this.ruleSpec = ruleSpec;
        this.rollPins = rollPins;
    }

    protected boolean haveStrike() {
        return rollPins == ruleSpec.getPinsNumber();
    }

    public int getPins() {
        return rollPins;
    }
}
