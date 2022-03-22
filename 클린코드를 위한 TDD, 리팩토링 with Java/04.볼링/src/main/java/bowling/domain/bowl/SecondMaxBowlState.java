package bowling.domain.bowl;

import bowling.domain.frame.Pin;

import static bowling.domain.frame.FrameStatus.SPARE;

public class SecondMaxBowlState extends BowlState {
    SecondMaxBowlState(BowlState state) {
        super(state);
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
        BowlState nextState = getFrameStatus() == SPARE
                ? new SpareBonusBowlState(this)
                : new GameOverBowlState(this);
        bowl.setState(nextState);
    }


}
