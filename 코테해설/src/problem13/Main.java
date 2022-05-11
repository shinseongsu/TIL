package problem13;

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리
// BFS -> 재귀, Stack
// DFS -> Queue

public class Main {
    public int solution(int delay, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 1;

        for (int i = 1; i <= N; i++) {
            Queue<Integer> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int d = queue.remove();
                if (d == 0) {
                    newQueue.add(0);
                    newQueue.add(delay);
                    count += 2;
                } else {
                    newQueue.add(d-1);
                }
            }
            queue = newQueue;
        }
        return count;
    }

    public static void main(String[] args) {
        int delay = 3;
        int N = 4;
        Main main = new Main();
        System.out.println(main.solution(delay, N));
    }

}
