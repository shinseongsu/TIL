package bronze5.problem3003;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int[] chess = { 1, 1, 2, 2, 2, 8 };

        for(int i = 0 ; i < chess.length ; i++) {
            System.out.println( chess[i] - sc.nextInt() );
        }

    }
}
