package problem01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (sum-a[i]-a[j] == 100) {
                    for (int k=0; k<n; k++) {
                        if (i==k || j==k) continue;
                        System.out.println(a[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
