package problem11;

import java.util.Arrays;

// 그래프 문제
// {1,3} , {2,4}  - edge
// 유항 그래프

public class Main {

    // 선생님 코드
    public int solution(int N, int[][] trust) {
        if (trust.length == 0) {
            return -1;
        }

        // 시간복잡도: O(NM) -> N과 M이 비슷하니 O(N^2)
        for (int i = 1; i <= N; i++) {
            int finalI = i;
            // 마을 판사는 아무도 믿지 않는다. && 모두 마을 판사를 가르키는지
            if (Arrays.stream(trust)
                    .noneMatch(x -> x[0] == finalI) &&
                    Arrays.stream(trust)
                            .filter(x -> x[1] == finalI)
                            .count() == (N-1)) {
                return finalI;
            }
        }
        return -1;
    }

    // 시간 복잡도 : O(nlogn)
    public int solution2(int N, int[][] trust) {
        boolean[] give = new boolean[N+1];
        int[] receive = new int[N+1];

        for (int[] ints : trust) {
            give[ints[0]] = true;
            receive[ints[1]]++;
        }

        for(int i = 1; i < give.length ; i++) {
            if(!give[i] && receive[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1,3}, {2,3}};
        Main main = new Main();
        System.out.println( main.solution(N, trust) );
    }

}
