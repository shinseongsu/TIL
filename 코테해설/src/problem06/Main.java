package problem06;

import java.util.Arrays;   // 프로그래머스 같은 경우는 외워서 써야 함

// nlogn -> 10만개 커버 가능
// O(1) -> O(logN) -> O(N) -> O(NlogN) -> O(N^2) -> O(2^N)

public class Main {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);  // nLogn -> 시간복잡도 (팀소트)
        for (int i = 0; i <numbers.length - 1; i++) {   // 시간복잡도 O(N)
            if (numbers[i] + 1 != numbers[i+1]) {
                return numbers[i] + 1;
            }
        }
        return - 1;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[] { 9, 4, 2, 3, 7, 5 }));
    }
}
