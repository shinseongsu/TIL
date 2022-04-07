import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dan = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " X "+ i +" = " + (dan * i));
        }

        // for(초기화 ; 조건 ; 증감문) {
        //       반복해서 수행하는 문장
        // }

    }

}
