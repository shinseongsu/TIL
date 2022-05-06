package problem04;

import java.util.*;
class Edge {
    int to, cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
class Pair {
    public int diameter;
    public int height;
    Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}
public class Main4 {
    static ArrayList<Edge>[] a;
    static boolean[] check = new boolean[10001];
    static Pair dfs(int x) {
        check[x] = true;
        ArrayList<Integer> heights = new ArrayList<>();
        int ans = 0;
        for (Edge e : a[x]) {
            int y = e.to;
            int cost = e.cost;
            if (check[y] == false) {
                Pair p = dfs(y);
                if (ans < p.diameter) ans = p.diameter;
                heights.add(p.height+cost);
            }
        }
        int height = 0;
        Collections.sort(heights, Collections.reverseOrder());
        if (heights.size() >= 1) {
            height = heights.get(0);
            if (ans < height) {
                ans = height;
            }
        }
        if (heights.size() >= 2) {
            int temp = heights.get(0) + heights.get(1);
            if (ans < temp) {
                ans = temp;
            }
        }
        return new Pair(ans, height);
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
        Pair ans = dfs(1);
        System.out.println(ans.diameter);
    }
}