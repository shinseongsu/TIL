package chapter03;

// 배열 arr의 데이터 순서를 거꾸로 변경하세요.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length -1 -i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

}
