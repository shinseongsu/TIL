package ladder.exception;

public class BadPositionException extends RuntimeException{

    private BadPositionException() {
        super("position은 사람의 명수보다 적어야 합니다.");
    }

    public static BadPositionException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadPositionException instance = new BadPositionException();
    }

}
