package bronze5.problem14645;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int busStop = sc.nextInt();
        int human = sc.nextInt();

        for(int i = 0 ; i < busStop ; i++) {
            human += sc.nextInt();
            human -= sc.nextInt();
        }

        System.out.println("비와이");

    }
}
