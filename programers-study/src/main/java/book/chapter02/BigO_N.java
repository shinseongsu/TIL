package book.chapter02;

public class BigO_N {

    // O(N) 시간 복잡도
    private int search(int[] array, int target) {
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
