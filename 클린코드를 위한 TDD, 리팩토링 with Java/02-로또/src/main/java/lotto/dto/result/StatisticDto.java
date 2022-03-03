package lotto.dto.result;

import lotto.domain.Money;
import lotto.domain.Result;

public class StatisticDto {
    private final Result result;
    private final Money purchaseMoney;

    public StatisticDto(Result result, Money purchaseMoney) {
        this.result = result;
        this.purchaseMoney = purchaseMoney;
    }

    public Result getResult() {
        return result;
    }

    public Money getPurchaseMoney() {
        return purchaseMoney;
    }
}
