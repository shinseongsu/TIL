package week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int solution(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        int m = 4;

        int numerator = 1;
        int denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= n - i;
            denominator *= (i + 1);
        }

        return numerator / denominator;
    }

    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바", "스쿨", "자바", "베이스", "베이스", "백엔드", "화이팅"};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(names));
    }

}
