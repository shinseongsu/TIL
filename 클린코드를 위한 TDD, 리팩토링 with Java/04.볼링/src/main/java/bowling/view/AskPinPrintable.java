package bowling.view;

import bowling.dto.AskPinDto;

public class AskPinPrintable extends Printable {
    AskPinPrintable(AskPinDto askPinDto) {
        append(lineSeparator);
        append(String.format("%s's turn : ", askPinDto.getName()));
    }
}
