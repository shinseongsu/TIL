package problem12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public int solution(int[] numbers, int target) {
        Set<Integer> set = Arrays.stream(numbers)
                .boxed().collect(Collectors.toSet());
        Set<Integer> historySet = new HashSet<>(Set.copyOf(set));

        if (set.contains(target)) {
            return 1;
        }

        for (int i = 2; i <= 10000; i++) {
            Set<Integer> newSet = new HashSet<>();
            set.forEach(x -> {
                for (int number : numbers) {
                    if (x + number <= target) {
                        newSet.add(x + number);
                    }
                    if (x * number <= target) {
                        newSet.add(x * number);
                    }
                }
            });

            newSet.addAll(historySet);
            set = newSet;
            historySet.addAll(set);

            if (set.contains(target)) {
                return i;
            }
            if (set.isEmpty()) {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] numbers = {1, 4, 2};
        int target = 12;
        System.out.println( main.solution(numbers, target) );
    }

}
