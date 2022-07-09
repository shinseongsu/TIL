package tree.problem03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    class Node {
        int n;
        int win = 0, lose = 0;
        boolean vist = false;
        List<Node> links = new LinkedList<>();
        Node(int n) { this.n = n; }
    }

    public int solution(int n, int[][] results) {
        List<Node> list = new ArrayList<>();
        for(int i =0; i<n; i++) list.add(new Node(i+1));

        for(int[] result : results) {
            Node winner = list.get(result[0] - 1);
            Node loser = list.get(result[1] -1);
            winner.links.add(loser);
        }

        for(Node winner: list) {
            for(Node node: list) { node.vist = false; }

            Queue<Node> queue = new LinkedList<>();

            winner.vist = true;
            queue.offer(winner);
            while(!queue.isEmpty()) {
                Node now = queue.poll();

                for(Node loser: now.links) {
                    if(loser.vist) continue;
                    loser.vist = true;

                    queue.offer(loser);
                    winner.win += 1;
                    loser.lose += 1;
                }
            }
        }

        int answer = 0;
        for(Node node: list) {
            if(node.win + node.lose == n - 1) answer++;
        }
        return answer;

    }
}
