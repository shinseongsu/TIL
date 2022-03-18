package ladder.dto;

public class PointDto {
    private final boolean isLeft;

    public PointDto(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public boolean getIsLeft() {
        return isLeft;
    }
}
