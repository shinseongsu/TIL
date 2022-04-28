package problem10;

import java.util.*;
public class Main {
    static int[] a = new int[10];
    static int[] num = new int[10];
    static int[] cnt = new int[10];
    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i=0; i<m; i++) {
                System.out.print(num[a[i]] + " ");
            }
            System.out.println();
            return;
        }
        for (int i=start; i<n; i++) {
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                a[index] = i;
                go(index+1, i, n, m);
                cnt[i] += 1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] temp = new int[n];
        for (int i=0; i<n; i++) {
            temp[i] = sc.nextInt();
        }
        Arrays.sort(temp);
        int k = 0;
        int x = temp[0];
        int c = 1;
        for (int i=1; i<n; i++) {
            if (x == temp[i]) {
                c += 1;
            } else {
                num[k] = x;
                cnt[k] = c;
                k += 1;
                x = temp[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
        n = k+1;
        go(0, 0, n, m);
    }
}