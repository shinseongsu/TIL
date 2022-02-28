package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest(name = "[Validator] validateInput 테스트 - {index}")
    @ValueSource(strings = {"", " "})
    void validateInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.validateInput(input);
        });
    }

}
