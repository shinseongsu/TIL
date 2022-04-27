package problem05;

import java.util.Arrays;

// or +
// and x
// OR -> A + B
// AND -> A x B
public class Main {
    public long solution(int N, int M, int K, int[] capacity) {
        int capacitySum = Arrays.stream(capacity).sum();

        long studentCase = 1;
        if (capacitySum == N) { // 학생수와 공간이 맞는 경우
            int studentLeft = N;
             for (int cap : capacity) {
                 studentCase *= nChooseK(studentLeft, cap);
                 studentLeft -= cap;
             }
        }
        else { // 학생수보다 공간이 더 많은 경우
            studentCase = 0;
            long capacityNult = Arrays.stream(capacity).asLongStream()
                    .reduce(1, (x,y) -> x*(y+1));

            indexLoop:
            for (int i = 0; i < capacityNult; i++) {
                int[] caps = new int[M];
                long denominator = capacityNult;
                long numerator = i;
                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    denominator /= capacity[i] + 1;
                    caps[j] = (int)(numerator / denominator);
                    numerator %= denominator;

                    currentSum += caps[j];
                    if (currentSum > N) {
                        continue  indexLoop;
                    }
                }

                long currentCase = 1;
                if (Arrays.stream(caps).sum() == N) {
                    int studentLeft = N;
                    for (int cap: caps) {
                        currentCase *= nChooseK(studentLeft, cap);
                        studentLeft -= cap;
                    }
                    studentCase += currentCase;
                }
            }
        }

        // nPm = n!/(n-m)!
        long kPm = 1;
        for (int i = K - M + 1; i <= K; i++) {
            kPm *= i;
        }

        return studentCase * kPm;
    }

    private long nChooseK (int n, int k) {
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator += n - i;
            denominator += i + 1;
        }
        return numerator / denominator;
    }

}
