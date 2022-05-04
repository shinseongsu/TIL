package problem02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 간선 리스트
class Edge implements Comparable<Edge> {
    int from, to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.from < that.from) {
            return -1;
        } else if (this.from == that.from){
            if (this.to < that.to) {
                return -1;
            } else if (this.to == that.to) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main2 {
    static Edge[] edge;
    static int[] cnt;
    static boolean[] check;

    static void dfs(int node) {
        check[node] = true;
        System.out.print(node + " ");
        for (int i=cnt[node-1]; i<cnt[node]; i++) {
            int next = edge[i].to;
            if (check[next] == false) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");
            for (int i=cnt[node-1]; i<cnt[node]; i++) {
                int next = edge[i].to;
                if (check[next] == false) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        edge = new Edge[2*m];
        cnt = new int[n+1];
        check = new boolean[n+1];
        for (int i =0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edge[i] = new Edge(from, to);
            edge[m+i] = new Edge(to, from);
        }
        m *= 2;
        Arrays.sort(edge);
        for (int i=0; i<m; i++) {
            cnt[edge[i].from] += 1;
        }
        for (int i=1; i<=n; i++) {
            cnt[i] += cnt[i-1];
        }
        dfs(start);
        System.out.println();
        check = new boolean[n+1];
        bfs(start);
        System.out.println();
    }
}
