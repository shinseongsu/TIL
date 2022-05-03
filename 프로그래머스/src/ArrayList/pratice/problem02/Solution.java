package ArrayList.pratice.problem02;

import java.util.Arrays;

public class Solution {
    public boolean solution(int[] arr) {
        // n : 1 ~ n

        // O(n^2) - 효율성 문제
        for (int i=1; i<arr.length; i++) {

            int found = 0;
            for (int a: arr) {
                if (a == i) found++;
            }

            if (found != 1) return false;
        }

        return true;
    }

    // O(nlogn)
    public boolean solution2(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i=0; i<arr.length; i++) answer[i] = i+1;  // O(n)

        Arrays.sort(arr);       // O(nlogn)

        return Arrays.equals(answer, arr);  // O(n)
    }

}
