package problem11;

import java.util.*;
public class Main1 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];
    static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(num[a[i]]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<n; i++) {
            //if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            ans.append(go(index+1, n, m));
            c[i] = false;
        }
        return ans;
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
        for (int i=0; i<n; i++) {
            if (i > 0 && temp[i] == temp[i-1]) continue;
            num[k++] = temp[i];
        }
        n = k;
        System.out.print(go(0,n,m));
    }
}