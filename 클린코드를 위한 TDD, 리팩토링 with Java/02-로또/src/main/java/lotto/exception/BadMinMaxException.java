package lotto.exception;

public class BadMinMaxException extends RuntimeException {

    private BadMinMaxException() {
        super("min은 max 보다 작은 양수여야 합니다.");
    }

    public static BadMinMaxException getInstance() {
        return SIngletonHelper.instance;
    }

    private static class SIngletonHelper {
        private static final BadMinMaxException instance = new BadMinMaxException();
    }

}
