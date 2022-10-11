package week1;

import java.util.Arrays;

public class Solution1 {

    // 에라스토테네스의 체
    public int solution(int n) {
        int[] intArray = new int[n];

        for (int i = 2; i < n; i++) {
            intArray[i] = 1;
        }

        for (int i = 2; i <= (int) Math.sqrt(n) ; i++) {
            if(intArray[i] == 0) continue;

            int num = i * 2;
            while (num < n) {
                intArray[num] = 0;
                num += i;
            }
        }

        return Arrays.stream(intArray).sum();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println( solution1.solution(15) );
    }

}
