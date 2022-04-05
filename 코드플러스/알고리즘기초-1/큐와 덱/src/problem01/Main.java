package problem01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] queue = new int[n];
        int begin = 0;
        int end = 0;

        while(n-- > 0) {
            String cmd = sc.next();

            if(cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue[end++] = num;
            } else if (cmd.equals("front")) {
                if(begin == end) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue[begin]);
                }
            } else if (cmd.equals("size")) {
                System.out.println(end - begin);
            } else if (cmd.equals("empty")) {
                if(begin == end) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("pop")) {
                if(begin == end) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue[begin]);
                    begin += 1;
                }
            } else if (cmd.equals("back")) {
                if (begin == end) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue[end-1]);
                }
            }

        }

    }

}
