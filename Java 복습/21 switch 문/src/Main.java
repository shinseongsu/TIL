import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1, 2, 3, 4 ,5, 6, 7, 8, 9, 10, 11, 12
        // 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

        Scanner scanner = new Scanner(System.in);

        int month = scanner.nextInt();
        int day = 0;

        if (month == 1) {
            day = 31;
        } else if (month == 2) {
            day = 28;
        } else if (month == 3) {
            day = 31;
        } else if (month == 4) {
            day = 30;
        } else if (month == 5) {
            day = 31;
        } else if (month == 6) {
            day = 30;
        } else if (month == 7) {
            day = 31;
        } else if (month == 8) {
            day = 31;
        } else if (month == 9) {
            day = 30;
        } else if (month == 10) {
            day =31;
        } else if (month == 11) {
            day =30;
        } else if(month == 12) {
            day = 31;
        } else {
            System.out.println("month값이 유효하지 않습니다.");
        }

        // 위의 조건문 switch문으로 변경하기
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;

            case 2:
                day = 29;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;

            default:
                System.out.println("month 값이 유효하지 않습니다.");

        }


        System.out.println("day = " + day);

    }
}
