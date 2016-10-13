/**
 * Created by ehsangolshani on 10/9/16.
 */
public class GameRule {

    private GameRuleSpec gamespec;
    private int strikeAward;
    private int spareAward;
    private int mainFramesNumber;

    public GameRule(GameRuleSpec gamespec, int strikeAward, int spareAward, int mainFramesNumber) {
        this.gamespec = gamespec;
        this.strikeAward = strikeAward;
        this.spareAward = spareAward;
        this.mainFramesNumber = mainFramesNumber;
    }

    public int getMainFramesNumber() {
        return mainFramesNumber;
    }

    public int getSpareAward() {
        return spareAward;
    }

    public int getStrikeAward() {
        return strikeAward;
    }

    public GameRuleSpec getGamespec() {
        return gamespec;
    }
}
