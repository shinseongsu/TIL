package programmers.course3.problem02;

import java.util.LinkedList;
import java.util.Queue;

// 자료구조/알고리즘: BFS
// 시간 복잡도: O(n * m)
// 공간 복잡도: O(n * m)
public class Solution {
    final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // right, left, down, up

    public int solution(int[][] maps) {
        int rowSize = maps.length, colSize = maps[0].length;
        boolean[][] visited = new boolean[rowSize][colSize]; // O(n * m) 공간

        Queue<int[]> nextCells = new LinkedList<>(); // O(n * m) 공간
        nextCells.offer(new int[] {0, 0});
        visited[0][0] = true;

        int distance = 0;
        while (!nextCells.isEmpty()) { // O(n * m) 시간
            int size = nextCells.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] cell = nextCells.poll();
                if (cell[0] == rowSize - 1 && cell[1] == colSize - 1) {
                    return distance;
                }
                for (int[] direction : DIRECTIONS) {
                    int nextX = cell[0] + direction[0];
                    int nextY = cell[1] + direction[1];
                    boolean isInRange =
                        nextX >= 0 && nextX < rowSize &&
                            nextY >= 0 && nextY < colSize;
                    if (isInRange && !visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        nextCells.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
}
