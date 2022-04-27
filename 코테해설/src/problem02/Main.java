package problem02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public int solution(String names) {
        // 셋을 이용하여 중복을 제거
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        int m = 4;

        // nC4 => n(n-1)(n-2)(n-3) / 4!
        //     => n!/(n-r)!r!
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= n - i;
            denominator *= (i + 1);
        }

        return (int)(numerator / denominator);
    }
}
