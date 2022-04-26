package bronze5.problem15727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        while(n > 0) {
            n -= 5;
            result++;
        }

        System.out.println(result);
    }
}
