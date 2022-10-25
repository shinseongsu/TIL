package programmers.course2.problem01;

import java.util.Arrays;

// 시간 복잡도: O(n(m + mlogm))
public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i ++) { // O(n) 시간 -> n = commands.length
            int[] command = commands[i];
            int startIndex = command[0];
            int endIndex = command[1];
            int itemNum = command[2];

            int[] subArray = Arrays.copyOfRange(array, startIndex - 1, endIndex); // O(m) 시간, O(m) 공간 -> m = array.length
            Arrays.sort(subArray); // O(mlogm) 시간

            answer[i] = subArray[itemNum - 1];
        }
        return answer;
    }
}
