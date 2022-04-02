package problem04;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void solve(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<Integer>();
        int m = 0;
        StringBuilder sb = new StringBuilder();

        for(int x : a) {
            if(x > m) {
                while(x > m) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.pop() != x) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }

        solve(a);
    }


}
