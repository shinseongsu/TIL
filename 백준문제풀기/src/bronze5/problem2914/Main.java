package bronze5.problem2914;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int musics = sc.nextInt();
        int avergae = sc.nextInt();

        System.out.println( musics * ( avergae-1 ) +1 );

    }
}
