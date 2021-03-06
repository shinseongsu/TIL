package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, Rank> cache = new HashMap<>();

    static {
        cache.put(3, FIFTH);
        cache.put(4, FOURTH);
        cache.put(5, THIRD);
        cache.put(6, FIRST);
    }

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        return cache.getOrDefault(countOfMatch, MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
