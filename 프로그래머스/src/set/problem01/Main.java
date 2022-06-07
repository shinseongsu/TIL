package set.problem01;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public boolean solution(int[] lotto) {
        Set<Integer> set = new HashSet<>();
        for (int l : lotto) {
            if(l < 1 || l > 45) return false;
        }
        return set.size() == lotto.length;

    }
}
