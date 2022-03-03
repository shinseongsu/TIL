package lotto.view.printable;

import lotto.dto.result.LottosDto;

public class LottoPrintable extends Printable{

    private final LottosDto dto;

    public LottoPrintable(LottosDto lottosDto) {
        dto = lottosDto;
    }

    @Override
    public void print() {
        println(dto.getLottos());
    }
}
