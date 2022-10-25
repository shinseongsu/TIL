package programmers.course2.problem04;

import java.util.Arrays;

// 시간 복잡도: O(m(logm + logn))
public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // O(mlogm) 시간, m = times.length

        long min = 1;
        long max = n * times[times.length - 1];
        long minTotalTime = max;

        while (min <= max) { // O(logn) 시간
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) { // O(m) 시간
                count += mid / times[i];
            }

            if (count < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                minTotalTime = Math.min(minTotalTime, mid);
            }
        }

        return minTotalTime;
    }
}
