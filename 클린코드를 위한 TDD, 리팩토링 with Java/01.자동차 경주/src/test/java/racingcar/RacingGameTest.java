package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import recingcar.controller.RacingGame;
import recingcar.exception.CarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest(name = "[RacingGame] 입력 받은 댓수 만큼 자동차 생성 테스트")
    @ValueSource(strings = {"pobi,crong,honux"})
    void readyGameTest(String input) {
        racingGame.readyGame(input);
        assertThat(racingGame.cars.size()).isEqualTo(3);
    }


    @ParameterizedTest(name = "[RacingGame] validateName 테스트 - {index}")
    @ValueSource(strings = {"", "abcdef", "abcdefg"})
    void validateNameTest(String input) {
        assertThatThrownBy(() -> {
            racingGame.validateName(input);
        }).isInstanceOf(CarNameException.class);
    }

}
