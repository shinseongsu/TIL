package StackAndQueue.problem02;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < progresses.length; i++) {
            float p = progresses[i];
            float s = speeds[i];
            int days = (int) Math.ceil((100 - p) / s);
            queue.offer(days);
        }

        Queue<Integer> answer = new LinkedList<>();
        int d = queue.poll();
        int count = 1;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if (d >= n) {
                count++;
                continue;
            }

            answer.offer(count);
            count = 1;
            d = n;
        }
        answer.offer(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
