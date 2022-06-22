package graph.problem01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(visited[n]) continue;
            answer++;
            visitAllConnectedComputers(computers, visited, i);
        }

        return answer;
    }

    void visitAllConnectedComputers(final int[][] computers, boolean[] visited, int c) {
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while(q.isEmpty()) {
            int l = q.poll();
            visited[l] = true;
            for(int j=0 ; j<computers[l].length; j++) {
                if(visited[j]) continue;
                if(computers[l][j] == 1) q.offer(j);
            }
        }
    }


    void visitAllConnectedComputers2(final int[][] computers, boolean[] visited, int c) {
        // DFS
        Stack<Integer> q = new Stack<>();
        q.push(c);
        while(q.isEmpty()) {
            int l = q.pop();
            visited[l] = true;
            for(int j=0 ; j<computers[l].length; j++) {
                if(visited[j]) continue;
                if(computers[l][j] == 1) q.push(j);
            }
        }
    }

}
