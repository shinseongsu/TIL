package programmers.course2.problem07;

// 자료구조/알고리즘: 완전탐색 (DFS)
// 시간 복잡도: O(n^2)
// 공간 복잡도: O(n)
public class Solution {
    int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int count = 0;
        visitDungeon(k, dungeons, visited, count);
        return maxCount;
    }

    private void visitDungeon(int energy, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            int energyRequired = dungeons[i][0];
            int energyUsed = dungeons[i][1];
            if (!visited[i] && energy >= energyRequired) {
                visited[i] = true;
                visitDungeon(energy - energyUsed, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        maxCount = Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][] { {80,20}, {50,40},{30,10} }));
    }
}
