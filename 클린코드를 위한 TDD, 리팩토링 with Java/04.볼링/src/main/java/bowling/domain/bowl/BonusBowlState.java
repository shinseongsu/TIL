package bowling.domain.bowl;

import bowling.domain.frame.Pin;

public class BonusBowlState extends BowlState {
    private int leftBonus;

    BonusBowlState(BowlState state, int leftBonus) {
        super(state);
        this.leftBonus = leftBonus;
    }

    @Override
    int getFrameNumberAdder() {
        return 0;
    }

    @Override
    boolean isPlayable() {
        return true;
    }

    @Override
    void addPin(Pin pin, Bowl bowl) {
        updateCurrentFrame(pin);
    }

    @Override
    void updateState(Bowl bowl) {
        if(--leftBonus <= 0) {
            bowl.setState(new GameOverBowlState(this));
        }
    }
}
