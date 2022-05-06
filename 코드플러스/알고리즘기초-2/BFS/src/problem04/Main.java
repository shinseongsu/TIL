package problem04;

import java.util.*;

// 큐이용
public class Main {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now*2 == next) {
                            q.add(next);
                            d[next] = d[now];
                        } else {
                            next_queue.add(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Integer>();
            }
        }
        System.out.println(d[m]);
    }
}