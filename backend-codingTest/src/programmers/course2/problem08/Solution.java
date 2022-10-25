package programmers.course2.problem08;

import java.util.ArrayList;
import java.util.List;

// 자료구조/알고리즘: 완전탐색
// 시간 복잡도: O(n)
// 공간 복잡도: O(1)
public class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1Answers = {1, 2, 3, 4, 5};
        int[] supoja2Answers = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3Answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correctAnswers = new int[3]; // O(3) == O(1) 공간
        for (int i = 0; i < answers.length; i++) { // O(n) 시간
            if (answers[i] == supoja1Answers[i % supoja1Answers.length]) {
                correctAnswers[0]++;
            }
            if (answers[i] == supoja2Answers[i % supoja2Answers.length]) {
                correctAnswers[1]++;
            }
            if (answers[i] == supoja3Answers[i % supoja3Answers.length]) {
                correctAnswers[2]++;
            }
        }
        int maxCorrectAnswers = Math.max(correctAnswers[0], Math.max(correctAnswers[1], correctAnswers[2]));
        List<Integer> mostCorrect = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // O(3) == O(1) 시간
            if (correctAnswers[i] == maxCorrectAnswers) {
                mostCorrect.add(i + 1);
            }
        }
        return mostCorrect.stream().mapToInt(Integer::intValue).toArray();
    }
}
