/**
 * Created by ehsangolshani on 10/9/16.
 */
public class RuleSpec {

    private int pinsNumber;
    private int attemptPerFrame;

    public RuleSpec(int pinsNumber, int attemptPerFrame) {
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
