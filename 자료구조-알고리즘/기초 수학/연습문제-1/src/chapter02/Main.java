package chapter02;

import java.util.Arrays;

public class Main {

    public static void solution(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        int idx = -1;
        for(int i = arr.length - 1 ; i >= 1 ; i--) {
            if(arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        if(idx == -1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        
        for (int i = arr.length - 1 ; i > idx ; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i-1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);

    }

}
