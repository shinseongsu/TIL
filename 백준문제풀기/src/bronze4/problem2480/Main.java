package bronze4.problem2480;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int check = 0;

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        if ( a == b ) queue.add(a);
        if ( a == c ) queue.add(a);
        if ( b == c ) queue.add(b);

        if(queue.size() == 0) {
            System.out.println(Math.max(a, Math.max(b, c)) * 100);
        } else if (queue.size()  == 1) {
            System.out.println( 1000 + (queue.poll() * 100)  );
        } else {
            System.out.println( 10000 + (queue.poll() * 1000) );
        }

    }
}
