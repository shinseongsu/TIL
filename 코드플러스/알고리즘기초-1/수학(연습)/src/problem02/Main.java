package problem02;

import java.util.Scanner;

public class Main {

    static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, y%x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0 ; i < n ; i++) {
            int x = sc.nextInt();
            int diff = Math.abs(x-s);
            a[i] = diff;
        }
        int ans = a[0];
        for(int i = 1; i < n ; i++) {
            ans = gcd(ans, a[i]);
        }
        System.out.println(ans);
    }

}
