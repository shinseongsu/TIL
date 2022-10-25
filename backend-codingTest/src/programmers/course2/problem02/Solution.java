package programmers.course2.problem02;

import java.util.Arrays;

// 시간 복잡도: O(n + nlogn)
public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // O(nlogn) 시간
        for (int i = 0; i < citations.length; i++) { // O(n) 시간
            int hIndex = citations.length - i;
            if (citations[i] >= hIndex){
                return hIndex;
            }
        }
        return 0;
    }
}
