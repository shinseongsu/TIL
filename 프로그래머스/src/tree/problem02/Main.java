package tree.problem02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    class Node {
        int n;
        int dist = 0;
        boolean visit = false;
        List<Node> links = new LinkedList<>();
        Node(int n) { this.n = n; }
    }

    public int solution(int n, int[][] edge) {
        List<Node> list = new ArrayList<>();
        for(int i =0; i < n; i++) list.add(new Node(i));

        for(int[] e: edge) {
            Node n1 =  list.get(e[0] - 1);
            Node n2 =  list.get(e[1]  -1);
            n1.links.add(n2);
            n2.links.add(n1);
        }

        int maxDist = 0;

        Queue<Node> queue = new LinkedList<>();
        Node fist = list.get(0);
        fist.visit = true;
        queue.offer(fist);
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(Node node: now.links) {
                if(node.visit) continue;

                node.visit = true;
                node.dist = now.dist + 1;
                queue.offer(node);

                maxDist = Math.max(maxDist, node.dist);
            }
        }

        int answer = 0;
        for(Node node: list) {
            if(node.dist == maxDist) answer++;
        }
        return answer;
    }

}
