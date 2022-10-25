package programmers.course4.problem03;

import java.util.*;

// 자료구조/알고리즘: 동적계획법
// 시간 복잡도: O(n + k)
// 공간 복잡도: O(n - k)
public class Solution {
    public int solution(int N, int number) {
        int maxN = 9;
        Set<Integer>[] combinations = new Set[maxN]; // O(maxN * m) == O(m) 공간
        int baseNum = N;
        for (int i = 1; i < maxN; i++) { // O(maxN) == O(1) 시간
            combinations[i] = new HashSet<>();
            combinations[i].add(baseNum);
            baseNum = baseNum * 10 + N;
        }

        // O(maxN^2 * m^2) == O(m^2) 시간
        for (int i = 1; i < maxN; i++) { // 1, 2, 3, 4, ... 8
            for (int j = 1; j < i; j++) { // 1, 2, ... i - 1
                for (int a : combinations[j]) { // combinations[1], 2, ...
                    for (int b : combinations[i - j]) { // combinations[0], 1, ...
                        combinations[i].add(a + b);
                        combinations[i].add(a - b);
                        combinations[i].add(b - a);
                        combinations[i].add(a * b);
                        if (b != 0) {
                            combinations[i].add(a / b);
                        }
                        if (a != 0) {
                            combinations[i].add(b / a);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < maxN; i++) { // O(maxN) == O(1) 시간
            if (combinations[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
