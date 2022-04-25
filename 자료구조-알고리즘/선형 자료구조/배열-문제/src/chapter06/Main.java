package chapter06;

// 배열 arr 에서 중복을 제거하여 새 배열 만들기
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false;
            for (int j = 0; j < cnt; j++) {
                if (arr[i] == arrResult[j]) {
                    dupFlag = true;
                }
            }

            if (dupFlag == false) {
                arrResult[cnt++] = arr[i];
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.print(arrResult[i] + " ");
        }
        System.out.println();
    }
}
