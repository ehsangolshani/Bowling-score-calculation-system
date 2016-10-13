/**
 * Created by ehsangolshani on 10/9/16.
 */
public class Roll {

    private int rollPins;
    GameRuleSpec gameRuleSpec;

    public Roll(GameRuleSpec gameRuleSpec, int rollPins) {
        this.gameRuleSpec = gameRuleSpec;
        this.rollPins = rollPins;
    }

    protected boolean haveStrike() {
        return rollPins == gameRuleSpec.getPinsNumber();
    }

    public int getPins() {
        return rollPins;
    }
}
