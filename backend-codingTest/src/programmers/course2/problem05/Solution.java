package programmers.course2.problem05;

import java.util.Arrays;

// 시간 복잡도: O(n(logn + logm))
// 공간 복잡도: O(1)
public class Solution {

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // O(nlogn) 시간, n = rocks.length

        int min = 0, max = distance;
        while (min < max) {
            int mid = (int) Math.ceil((double) (min + max) / 2);
            int previousRock = 0;
            int removeCount = 0;
            for (int rock : rocks) { // O(nlogm) 시간, m = distance
                int rockDistance = rock - previousRock;
                if (rockDistance < mid) {
                    removeCount++;
                } else {
                    previousRock = rock;
                }
            }
            if (removeCount > n) {
                max = mid - 1;
            } else {
                min = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution(25, new int[] { 2, 14, 11, 21, 17 }, 2  ) );
    }

}
