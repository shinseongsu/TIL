package problem03;

import java.util.Scanner;

public class Main1 {
    public static long mod = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[k+1][n+1];
        d[0][0] = 1;
        for(int i = 1; i <= k ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                d[i][j] = d[i-1][j];
                if(j-1 >= 0) {
                    d[i][j] += d[i][j-1];
                }
            }
        }
        System.out.println(d[k][n]);
    }
}
