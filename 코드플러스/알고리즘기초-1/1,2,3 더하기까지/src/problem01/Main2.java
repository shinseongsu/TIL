package problem01;

import java.util.Scanner;

// Bottom-UP 방식
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[1] = 0;

        for(int i = 2; i <= n ; i++) {
            d[i] = d[i-1] + 1;
            if(i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }
            if(i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}
