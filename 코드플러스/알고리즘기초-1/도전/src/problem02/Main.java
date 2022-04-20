package problem02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][3];
        int[][] d = new int[n+1][3];

        for(int i = 1; i<= n ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 1000 * 1000 + 1;
        for(int k = 0 ; k <= 2; k++) {
            for(int j = 0 ; j <= 2 ;j++) {
                if(j == k) {
                    d[1][j] = a[1][j];
                } else {
                    d[1][j] = 1000 * 1000 + 1;
                }
            }
            for(int i = 2; i <=n ; i++) {
                d[i][0] = Math.min( d[i-1][1], d[i-1][2]) + a[i][0];
                d[i][1] = Math.min( d[i-1][0], d[i-1][2]) + a[i][1];
                d[i][2] = Math.min( d[i-1][0], d[i-1][1]) + a[i][2];
            }
            for(int j = 0 ; j <= 2 ; j++) {
                if (j == k) continue;
                ans = Math.min(ans, d[n][j]);
            }
        }
        System.out.println(ans);
    }
}
