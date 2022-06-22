package graph.problem02;

public class Main {
    public int solution(int[] numbers, int target) {
        return sumCount(numbers,  target, 0, 0);
    }

    int sumCount(final int[] numbers, final int target, int i, int sum) {
        if(i == numbers.length) {
            if(sum == target) return 1;
            return 0;
        }

        return sumCount(numbers, target, i+1, sum + numbers[i]) +
            sumCount(numbers, target, i+1, sum - numbers[i]);
    }
}
