package lotto.dto.input;

import java.util.List;

public class PurchaseDto {

    private final int purchaseMoney;
    private final int numOfManuallottos;
    private final List<String> manualLottos;

    public PurchaseDto(int purchaseMoney, int numOfManuallottos, List<String> manualLottos) {
        this.purchaseMoney = purchaseMoney;
        this.numOfManuallottos = numOfManuallottos;
        this.manualLottos = manualLottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getNumOfManuallottos() {
        return numOfManuallottos;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
