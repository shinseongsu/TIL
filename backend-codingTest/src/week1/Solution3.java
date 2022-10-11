package week1;

public class Solution3 {
    public int solution (int N) {
        int a = 1, b = 2;

        if (N == 1) {
            return a;
        }

        for (int i = 3; i <= N; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(4));
    }

}
