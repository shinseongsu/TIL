package problem02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[n+1];
        for(int i = 1; i <= n ; i++) {
            d[i] = -1;
            for(int j = 1; j <= i ; j++) {
                if (d[i] == -1 || d[i] > d[i-j] + a[j]) {
                    d[i] = d[i-j] + a[j];
                }
            }
        }
        System.out.println(d[n]);
    }

}
