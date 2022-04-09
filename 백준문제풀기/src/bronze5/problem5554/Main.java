package bronze5.problem5554;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;

        for(int i = 0 ; i < 4 ; i++) {
            total += sc.nextInt();
        }

        System.out.println(total / 60);
        System.out.println(total % 60);

    }
}
