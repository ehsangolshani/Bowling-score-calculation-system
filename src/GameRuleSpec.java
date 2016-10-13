/**
 * Created by ehsangolshani on 10/9/16.
 */
public class GameRuleSpec {

    private int pinsNumber;
    private int attemptPerFrame;

    public GameRuleSpec(int pinsNumber, int attemptPerFrame) {
        this.pinsNumber = pinsNumber;
        this.attemptPerFrame = attemptPerFrame;
    }

    public int getPinsNumber() {
        return pinsNumber;
    }

    public int getAttemptPerFrame() {
        return attemptPerFrame;
    }
}
