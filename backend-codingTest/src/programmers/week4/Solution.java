package programmers.week4;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int index = B.length-1;
        int answer = 0;

        for(int i = A.length-1 ; i >= 0; i--) {
            if(A[i] < B[index]) {
                index--;
                answer++;
            }
        }

        return answer;
    }
}
