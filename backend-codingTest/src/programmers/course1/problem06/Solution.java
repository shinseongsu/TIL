package programmers.course1.problem06;

import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> cleanedNums = new Stack<>();
        cleanedNums.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (num != cleanedNums.peek()) {
                cleanedNums.push(num);
            }
        }
        return cleanedNums.stream().mapToInt(Integer::intValue).toArray();
    }
}
