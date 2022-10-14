package programmers.course1.problem08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 시간 복잡도: O(nlogn)
public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<PrintItem> waitList = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            waitList.offer(new PrintItem(i, priorities[i]));
        }
        Arrays.sort(priorities);

        int currentIndex = 0;
        int priorityIndex = priorities.length - 1;
        while (!waitList.isEmpty()) {
            PrintItem currentItem = waitList.poll();
            if (currentItem.priority == priorities[priorityIndex]) {
                currentIndex++;
                priorityIndex--;
                if (currentItem.location == location) {
                    break;
                }
            } else {
                waitList.offer(currentItem);
            }
        }
        return currentIndex;
    }

    class PrintItem {
        int location;
        int priority;

        public PrintItem(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
