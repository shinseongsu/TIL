package lotto.controller;

import lotto.domain.*;
import lotto.dto.result.LottosDto;
import lotto.dto.result.NumOfLottosDto;
import lotto.dto.result.StatisticDto;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Receipt receipt = InputMapper.getReceipt();
        NumOfLottosDto numOfLottosDto = new NumOfLottosDto(receipt.getNumOfManualLottos(), receipt.getNumOfAutoLottos());

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = new Lottos(receipt, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        LottosDto lottosDto = new LottosDto(lottos);
        ResultView.printLottos(lottosDto);

        WinningCondition condition = InputMapper.getWinningCondition();
        Result result = lottos.getResult(condition);
        StatisticDto statisticsDto = new StatisticDto(result, receipt.getPurchaseMoney());
        ResultView.printStatistics(statisticsDto);
    }
}
