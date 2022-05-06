package problem04;

import java.util.*;
class Edge {
    int to, cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main3 {
    static ArrayList<Edge>[] a;
    static boolean[] check = new boolean[10001];
    static int[] dist = new int[10001];
    static void bfs(int start) {
        Arrays.fill(dist, 0);
        Arrays.fill(check, false);
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                if (check[e.to] == false) {
                    dist[e.to] = dist[x] + e.cost;
                    q.add(e.to);
                    check[e.to] = true;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = (ArrayList<Edge>[]) new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            a[u].add(new Edge(v, w));
            a[v].add(new Edge(u, w));
        }
        bfs(1);
        int start = 1;
        for (int i=2; i<=n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        bfs(start);
        int ans = dist[1];
        for (int i=2; i<=n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}