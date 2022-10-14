package programmers.course1.problem12;

import java.util.PriorityQueue;

// 시간 복잡도: O(nlogn)
public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> minScoville = new PriorityQueue<>();
        for (int score : scoville) {
            minScoville.offer((long)score);
        }

        int mixCount = 0;
        while (minScoville.peek() < K) {
            if (minScoville.size() < 2) {
                return -1;
            }
            long newScore = minScoville.poll() + 2 * minScoville.poll();
            minScoville.offer(newScore);
            mixCount++;
        }

        return mixCount;
    }
}
