package book.chapter03;

public class Section3_1 {

    /**
     * 원소 접근하기
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr2 = {
                {4, 9, 7},
                {2, 6, 1},
                {3, 4, 8},
                {8, 5, 9}
        };

        int element = arr2[3][2];
        System.out.println("element = " + element); // 9
    }

}
