package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Networrk {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i =0; i<n; i++) {
            if(visited[i]) continue;
            answer++;
            visitAllConnectedComputers(computers, visited, i);
        }

        return answer;
    }

    void visitAllConnectedComputers(final int[][] computers, boolean[] visited, int c) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while (!q.isEmpty()) {
            int i = q.poll();
            visited[i] = true;
            for(int j = 0; j < computers[i].length; j++) {
                if(visited[j]) continue;
                if(computers[i][j] == 1) q.offer(j);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Networrk().solution(3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}} ));
    }
}
