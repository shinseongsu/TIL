package lotto.view.printable;

import lotto.dto.result.NumOfLottosDto;

public class NumOfLottosPrintable extends Printable {

    private final NumOfLottosDto dto;

    public NumOfLottosPrintable(NumOfLottosDto dto) {
        this.dto = dto;
    }

    @Override
    public void print() {
        println("수동으로 " + dto.getNumOfManualLottos() + "창, 자동으로 " + dto.getNumOfAutoLottos() + "개를 구매했습니다.");
    }
}
