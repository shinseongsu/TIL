package bronze5.problem11283;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char input = sc.next().charAt(0);

        System.out.println( (int) input - (int) '가' + 1 );

    }
}
