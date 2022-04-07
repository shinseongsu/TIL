import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dan = scanner.nextInt();

        int i = 1;

        while(i <= 9) {
            System.out.println(dan + " X " + i + " = " + (dan * i));
            i++;
        }

        // 무조건 한번은 실행하는 반복문
        i = 1;
        do {
            System.out.println(dan + " X " + i + " = " + (dan * i));
            i++;
        } while( i <= 9);



    }

}
