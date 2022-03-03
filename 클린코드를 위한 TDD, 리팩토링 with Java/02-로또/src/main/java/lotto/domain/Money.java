package lotto.domain;

import lotto.exception.BadDividerException;
import lotto.exception.BadMoneyException;

public class Money {
    private final int money;

    Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw BadMoneyException.getInstance();
        }
    }

    double divide(Money divider) {
        if (divider.money <= 0) {
            throw BadDividerException.getInstance();
        }
        return (double) money / divider.money;
    }

    @Override
    public String toString() {
        return Integer.toString(money);
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
