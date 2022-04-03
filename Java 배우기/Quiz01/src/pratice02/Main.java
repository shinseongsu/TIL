package pratice02;

import java.util.Scanner;

public class Main {

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 입력: ");
        char input = sc.nextLine().charAt(0);

        int output = 0;
        int stop = (int)'a' - (int)'A';

        if(input >= 'a' && input <= 'z') {
            output = (int) input - stop;
            System.out.println("대문자 변환: " + (char) output);
        }  else if (input >= 'A' && input <= 'Z') {
            output = (int) input + stop;
            System.out.println("소문자 변환: " + (char) output);
        } else {
            System.out.println("입력하신 값이 알파벳이 아닙니다.");
        }

    }

    public static void main(String[] args) {
        solution();
    }
}
