package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import recingcar.model.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("nana");
    }

    @Test
    @DisplayName("[Car] 자동차 이동 테스트")
    void moveTest() {
        assertThat(car.getLocation()).isEqualTo(0);
        car.move();
        assertThat(car.getLocation()).isEqualTo(1);
    }

}
