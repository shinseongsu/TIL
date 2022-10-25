package programmers.course2.problem09;

import java.util.Arrays;

/*
- 자료구조/알고리즘: 완전탐색
- 시간 복잡도: O(n)
- 공간 복잡도: O(1)
*/
public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] carpetSize = new int[2];
        int totalCount = brown + yellow;
        for (int width = 1; width < brown; width++) { // O(n) 시간, n == brown
            int height = totalCount / width;
            if ((width - 2) * (height - 2) == yellow) {
                carpetSize[0] = width;
                carpetSize[1] = height;
            }
        }
        return carpetSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString( solution.solution(10, 2) ) );
    }

}
