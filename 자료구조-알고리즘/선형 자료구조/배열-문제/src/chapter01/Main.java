package chapter01;

// 짝수 데이터, 홀수 데이터의 평균을 출력하세요
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        float sumEven = 0;
        float sumOdd = 0;
        int eventCnt = 0;
        int oddCnt = 0;

        for (int item: arr) {
            if (item % 2 == 0) {
                sumEven += item;
                eventCnt++;
            } else {
                sumOdd += item;
                oddCnt++;
            }
        }

        System.out.println("짝수 평균: " + sumEven / eventCnt);
        System.out.println("홀수 평균: " + sumOdd / oddCnt);
    }
}
