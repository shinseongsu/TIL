package problem03;

// 재귀 vs 반복
// 속도랑 메모리에 재귀에 장점이 없다.
// 반복이 더좋다.
// 하지만 재귀가 가독성이 좋다.
public class Main {
    public int solution(int N) {
        // f(n) = f(n-1) + f(n-2)
        // f(1) = 1, f(2) = 2
        int a = 1, b = 2;

        if (N == 1) return a;

        // a <- f(n-1)
        // b <- f(n)
        for (int i = 3; i <= N; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    // 재귀식
    public int solution2(int N) {
        if (N <= 2) {
            return N;
        }

        return solution2(N-1) + solution2(N-2);
    }

}
