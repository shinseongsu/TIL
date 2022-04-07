package problem06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        for(int i = 2; i <= n ; i++) {
            ans *= i;
        }
        System.out.println(ans);
    }
}
