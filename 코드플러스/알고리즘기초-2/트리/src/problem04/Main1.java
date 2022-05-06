package problem04;

import java.util.*;
class Edge {
    public int to;
    public int cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main1 {
    public static int[] bfs(int n, List<Edge>[] a, int start) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                int y = e.to;
                int cost = e.cost;
                if (check[y] == false) {
                    dist[y] = dist[x] + cost;
                    q.add(y);
                    check[y] = true;
                }
            }
        }
        return dist;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge>[] a = (List<Edge>[]) new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i=1; i<=n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();
                a[x].add(new Edge(y,z));
            }
        }
        int[] dist = bfs(n, a,1);
        int start = 1;
        for (int i=2; i<=n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(n, a, start);
        int ans = dist[1];
        for (int i=2; i<=n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}