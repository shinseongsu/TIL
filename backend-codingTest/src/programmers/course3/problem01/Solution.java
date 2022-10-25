package programmers.course3.problem01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 자료구조/알고리즘: BFS
// 시간 복잡도: O(n * m)
// 공간 복잡도: O(n)
public class Solution {
    public int solution(int n, int[][] edges) {
        Node[] nodes = new Node[n + 1]; // O(n) 공간
        for (int i = 1; i <= n; i++) { // O(n) 시간
            nodes[i] = new Node(i);
        }

        for (int[] edge : edges) { // O(m) 시간, m = edges.length
            nodes[edge[0]].addNeighbor(nodes[edge[1]]);
            nodes[edge[1]].addNeighbor(nodes[edge[0]]);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Node> nodesToVisit = new LinkedList<>();

        nodesToVisit.offer(nodes[1]);
        visited[1] = true;

        int distance = 0;
        int[] nodesPerDistance = new int[n + 1];

        while (!nodesToVisit.isEmpty()) { // O(n * m) 시간
            int size = nodesToVisit.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Node currentNode = nodesToVisit.poll();
                nodesPerDistance[distance]++;
                for (Node nextNode : currentNode.neighbors) {
                    if (!visited[nextNode.value]) {
                        nodesToVisit.offer(nextNode);
                        visited[nextNode.value] = true;
                    }
                }
            }
        }
        return nodesPerDistance[distance];
    }

    class Node {
        int value;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }
}
