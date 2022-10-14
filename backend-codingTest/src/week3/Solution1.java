package week3;

import java.util.Arrays;

public class Solution1 {

    public int solution (int N, int[][] trust) {
        if (trust.length == 0) {
            return -1;
        }

        for (int i = 1; i <= N; i++) {
            int finalI = i;
            if (Arrays.stream(trust).
                noneMatch(x -> x[0] == finalI) &&
                Arrays.stream(trust).
                    filter(x -> x[1] == finalI).
                    count() == (N - 1)) {
                return finalI;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(3, new int[][] { {1,3}, {2,3} }));
    }

}
