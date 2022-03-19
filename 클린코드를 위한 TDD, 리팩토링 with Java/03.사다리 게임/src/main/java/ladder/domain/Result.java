package ladder.domain;

import ladder.dto.ResultDto;
import ladder.exception.BadResultException;

import static ladder.asset.LadderConst.STANDARD_LENGTH;

public class Result {
    private final String result;

    public Result(String result) {
        if (result.length() > STANDARD_LENGTH) {
            throw BadResultException.getInstance();
        }
        this.result = result;
    }

    ResultDto exportResultDto() {
        return new ResultDto(result);
    }


}
