package programmers.course3.problem03;

// 자료구조/알고리즘: DFS
// 시간 복잡도: O(2^n)
// 공간 복잡도: O(1)
public class Solution {
    public int solution(int[] numbers, int target) {
        return getTotalWays(numbers, target, 0, 0);
    }

    private int getTotalWays(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        int totalWays = 0;
        totalWays += getTotalWays(numbers, target, index + 1, sum + numbers[index]);
        totalWays += getTotalWays(numbers, target, index + 1, sum - numbers[index]);
        return totalWays;
    }
}
