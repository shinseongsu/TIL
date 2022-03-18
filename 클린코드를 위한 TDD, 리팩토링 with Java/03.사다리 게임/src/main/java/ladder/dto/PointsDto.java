package ladder.dto;

import java.util.List;

public class PointsDto {
    private final List<Integer> positions;

    public PointsDto(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }

}
