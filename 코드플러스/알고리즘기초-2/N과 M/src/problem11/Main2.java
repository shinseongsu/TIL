package problem11;

import java.util.*;
class Result implements Comparable<Result> {
    Integer[] a;
    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }
    int get(int index) {
        return (int)this.a[index];
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Result) {
            Result that = (Result)obj;
            int n = this.a.length;
            for (int i=0; i<n; i++) {
                if (this.a[i] != that.a[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public int compareTo(Result that) {
        int n = this.a.length;
        for (int i=0; i<n; i++) {
            if (this.a[i] == that.a[i]) continue;
            if (this.a[i] < that.a[i]) return -1;
            if (this.a[i] > that.a[i]) return 1;
        }
        return 0;
    }
}

public class Main2 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];
    static ArrayList<Result> d = new ArrayList<>();
    static void go(int index, int start, int n, int m) {
        if (index == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<m; i++) {
                temp.add(num[a[i]]);
            }
            d.add(new Result(temp));
            return;
        }
        for (int i=start; i<n; i++) {
            //if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index+1, 0, n, m);
            c[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        go(0, 0, n, m);
        Collections.sort(d);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<d.size(); i++) {
            if (i == 0 || !d.get(i).equals(d.get(i-1))) {
                for (int j=0; j<m; j++) {
                    sb.append(d.get(i).get(j));
                    if (j != m-1) sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}