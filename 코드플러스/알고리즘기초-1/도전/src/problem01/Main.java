package problem01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        int[] s = new int[n+1];
        d[0] = 1;
        s[0] = 1;
        d[1] = 2;
        s[1] = d[0] + d[1];
        for(int i = 2; i <= n ; i++) {
            d[i] = d[i-1] + 2*s[i-2];
            s[i] = s[i-1] + d[i];
            d[i] = d[i] % 9901;
            s[i] = s[i] % 9901;
        }
        System.out.println(s[n]);
    }
}
