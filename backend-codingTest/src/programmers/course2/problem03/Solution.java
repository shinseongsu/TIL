package programmers.course2.problem03;

import java.util.Arrays;

// 시간 복잡도: O(n + nlogn)
public class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if ("0".equals(strNumbers[0])) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < strNumbers.length; i++) {
            answer.append(strNumbers[i]);
        }
        return answer.toString();
    }
}
