package problem03;

import java.util.Scanner;

public class Main2 {
    static final long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] d = new long[n+1];
        d[0] = 1;
        for(int i = 1; i <= m ; i++) {
            for(int j = 1; j <= n ; j++) {
                d[j] += d[j-1];
                d[j] %= mod;
            }
        }
        System.out.println(d[n]);
    }
}
