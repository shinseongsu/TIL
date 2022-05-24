package bronze4.problem1297;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int H_rate = sc.nextInt();
        int W_rate  = sc.nextInt();
        double answer = Math.sqrt(1.0*D*D/(H_rate*H_rate+W_rate*W_rate));
        System.out.println((int) Math.floor(answer*H_rate)+" "+(int) Math.floor(answer*W_rate));
        sc.close();
    }
}
