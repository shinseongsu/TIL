package programmers.course2.problem10;

// 자료구조/알고리즘: 완전탐색 (DFS)
// 시간 복잡도: O(n + m)
// 공간 복잡도: O(n^2)
public class Solution {
    int n;
    int minDiff;

    public int solution(int n, int[][] wires) {
        this.n = n;
        this.minDiff = n;

        boolean[] visited = new boolean[n + 1]; // O(n) 공간
        boolean[][] connected = new boolean[n + 1][n + 1]; // O(n^2) 공간
        for (int[] wire : wires) { // O(m) 시간, m = wires.length
            connected[wire[0]][wire[1]] = true;
            connected[wire[1]][wire[0]] = true;
        }

        countConnectedNodes(connected, visited, 1); // O(n) 시간

        return minDiff;
    }

    private int countConnectedNodes(boolean[][] connected, boolean[] visited, int node){
        visited[node] = true;
        int connectedNodes = 1;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && connected[node][i]) {
                visited[i] = true;
                connectedNodes += countConnectedNodes(connected, visited, i);
            }
        }
        int diff = Math.abs(connectedNodes - (n - connectedNodes));
        minDiff = Math.min(minDiff, diff);
        return connectedNodes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, new int[][] { {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9} }));
    }

}
