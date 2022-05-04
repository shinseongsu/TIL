package problem02;

import java.util.*;

// 비재귀 구현
class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Main3 {
    static ArrayList<Integer>[] a;
    static boolean[] c;

    public static void dfs(int x) {
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(x, 0));
        c[x] = true;
        System.out.print(x + " ");
        while (!s.isEmpty()) {
            Pair p = s.pop();
            int node = p.first;
            int start = p.second;
            for (int i=start; i<a[node].size(); i++) {
                int next = a[node].get(i);
                if (c[next] == false) {
                    System.out.print(next + " ");
                    c[next] = true;
                    s.add(new Pair(node, i+1));
                    s.add(new Pair(node, 0));
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
            for (int y : a[x]) {
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
        dfs(start);
        System.out.println();
        c = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}
