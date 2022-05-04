package problem02;

import java.util.*;

public class Main4 {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    public static void dfs(int x, int n) {
        int[] start = new int[n+1];
        Stack<Integer> s = new Stack<>();
        s.add(x);
        c[x] = true;
        System.out.print(x + " ");
        while (!s.isEmpty()) {
            int node = s.pop();
            for (; start[node]<a[node].size(); start[node]++) {
                int next = a[node].get(start[node]);
                if (c[next] == false) {
                    System.out.print(next + " ");
                    c[next] = true;
                    s.add(node);
                    s.add(next);
                    break;
                }
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y: a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
        }

        c = new boolean[n+1];
        dfs(start, n);
        System.out.println();
        c = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}
