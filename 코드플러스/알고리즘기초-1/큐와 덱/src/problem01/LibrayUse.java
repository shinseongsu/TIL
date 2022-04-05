package problem01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LibrayUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int k = 0 ;  k < n ; k++) {
            String cmd = sc.next();

            if(cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue.offer(num);
            } else if (cmd.equals("front")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peek());
                }
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.poll());
                }
            } else if (cmd.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.poll());
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    // ???? java에는 back 이 없음
                }
            }


        }

    }
}
