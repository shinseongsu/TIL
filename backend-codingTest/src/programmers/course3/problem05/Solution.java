package programmers.course3.problem05;

public class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1; //이김
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int z = 0; z <= n; z++) {
                    if (graph[j][i] == 1 && graph[i][z] == 1) {
                        graph[j][z] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1) {
                    game++;
                }
            }
            if (game == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

}
