package problem01;

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int[] parent = new int[n];
        int[] order = new int[n];
        boolean[] check = new boolean[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            order[i] = sc.nextInt()-1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        int m = 1;
        for (int i=0; i<n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            int x = q.remove();
            if (x != order[i]) {
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0;
            for (int y : a[x]) {
                if (check[y] == false) {
                    parent[y] = x;
                    cnt += 1;
                }
            }
            for (int j=0; j<cnt; j++) {
                if (m+j >= n || parent[order[m+j]] != x) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[m+j]);
                check[order[m+j]] = true;
            }
            m += cnt;
        }
        System.out.println(1);
    }
}