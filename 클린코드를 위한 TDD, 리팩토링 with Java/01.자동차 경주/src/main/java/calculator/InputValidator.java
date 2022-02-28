package calculator;

public class InputValidator {

    public static void validateInput(String input) {
        if(input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }

}
