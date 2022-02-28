package recingcar;

import recingcar.controller.RacingGame;
import recingcar.view.InputView;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.readyGame(InputView.inputNameOfCars());
        racingGame.run(InputView.inputNumOfAttempt());
    }

}
