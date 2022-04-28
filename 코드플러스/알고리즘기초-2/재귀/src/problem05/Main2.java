package problem05;

import java.util.*;

public class Main2 {
    static int n;
    static char[] a = new char[20];
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static boolean good(char x, char y, char op) {
        if (op == '<') {
            if (x > y) return false;
        }
        if (op == '>') {
            if (x < y) return false;
        }
        return true;
    }
    static void go(int index, String num) {
        if (index == n+1) {
            ans.add(num);
            return;
        }
        for (int i=0; i<=9; i++) {
            if (check[i]) continue;
            if (index == 0 || good(num.charAt(index-1), (char)(i+'0'), a[index-1])) {
                check[i] = true;
                go(index+1, num+Integer.toString(i));
                check[i] = false;
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray()[0];
        }
        go(0, "");
        Collections.sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));
    }
}