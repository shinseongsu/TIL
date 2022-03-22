package bowling.domain.frame;

import bowling.dto.PinsDto;
import bowling.exception.PinsOutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Pins {
    private final List<Pin> pins = new ArrayList<>();
    
    public void add(Pin pin) {
        pins.add(pin);
    }
    
    int size() {
        return pins.size();
    }
    
    int sum(int startIdx, int offset) {
        int endIdx = startIdx + offset;
        boolean isOutOfRange = startIdx < 0 || offset < 0 || endIdx > pins.size();
        if(isOutOfRange) {
            throw new PinsOutOfRangeException("pins의 범위를 벗어난 index입니다.");
        }
        return IntStream.range(startIdx, endIdx)
                .mapToObj(pins::get)
                .reduce(0, (acc, pin) -> pin.sum(acc), Integer::sum);
    }
    
    PinsDto exportPinsDto() {
        return pins.stream()
                .map(Pin::exportPinDto)
                .collect(collectingAndThen(toList(), PinsDto::new));
    }

}
