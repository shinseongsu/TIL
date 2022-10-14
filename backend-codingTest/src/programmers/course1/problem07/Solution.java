package programmers.course1.problem07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 시간 복잡도: O(n)
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployPlan = new ArrayList<>();
        Queue<Integer> finishedDays = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int finishedDay = canFinishWithin(progresses[i], speeds[i]);
            if (!finishedDays.isEmpty() && finishedDays.peek() < finishedDay) {
                deployPlan.add(finishedDays.size());
                finishedDays.clear();
            }
            finishedDays.offer(finishedDay);
        }
        deployPlan.add(finishedDays.size());

        return deployPlan.stream().mapToInt(Integer::intValue).toArray();
    }

    private int canFinishWithin(int progress, int speed) {
        return (int) Math.ceil((double)(100.0 - progress) / speed);
    }
}
