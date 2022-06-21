package StackAndQueue.problem04;

import java.util.LinkedList;
import java.util.List;

public class Main {
    class Paper {
        boolean isMine;
        int priority;
        Paper(int p, boolean m) { priority = p; isMine = m; }
    }

    public int solution(int[] priorities, int location) {
        List<Paper> queue = new LinkedList<>();
        for (int i = 0 ; i < priorities.length; i++) {
            queue.add(new Paper(priorities[i], i == location));
        }

        int answer = 0;
        while(!queue.isEmpty()) {
            Paper now = queue.remove(0);
            boolean printable = true;
            for (Paper p : queue) {
                if (now.priority < p.priority) {
                    printable = false;
                    break;
                }
            }

            if (!printable) {
                queue.add(now);
                continue;
            }

            answer++;
            if (now.isMine) return answer;
        }

        return answer;
    }
}
