package problem01;

import java.util.Arrays;

public class Main {
    public int solution(int n) {
        // 에라토스테네스의 체
        // 어떤 수의 배수는 소수가 아니므로, 범위 내에서 소수가 아닌 수를 제외하는 방식
        // 마치 체를 통과하듯이, 소수가 아닌 수를 순차적으로 제외
        int[] intArray = new int[n];

        // 1로 초기화
        for (int i =2; i < n; i++) {
            intArray[i] = 1;
        }

        // sqrt(n) 까지만 반복
        for (int i = 2; i<= (int)Math.sqrt(n); i++) {
            if (intArray[i] == 0) continue;

            int num = i * 2;
            while (num < n) {
                intArray[num] = 0;
                num += i;
            }
        }

        return Arrays.stream(intArray).sum();
    }
}
