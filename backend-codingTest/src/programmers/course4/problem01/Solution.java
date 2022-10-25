package programmers.course4.problem01;

// 자료구조/알고리즘: 탐욕법
// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n]; // O(n) 공간
        for (int lostStudent: lost) {
            clothes[lostStudent - 1]--;
        }
        for (int reservedStudent : reserve) {
            clothes[reservedStudent - 1]++;
        }

        int readyCount = n;
        for (int i = 0; i < clothes.length; i++) { // O(n) 시간
            if (clothes[i] == -1) {
                if (i > 0 && clothes[i - 1] == 1) {
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if (i < clothes.length - 1 && clothes[i + 1] == 1) {
                    clothes[i + 1]--;
                    clothes[i]++;
                } else {
                    readyCount--;
                }
            }
        }
        return readyCount;
    }

}
