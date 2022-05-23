import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Pratice1 {

    public static void reorderData(int[] arr) {
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> deque.addLast(x));
        System.out.println(deque);

        while (!deque.isEmpty()) {
            result.add(deque.removeFirst());

            if(!deque.isEmpty()) {
                result.add(deque.removeLast());
            }
        }

        System.out.println("== 정렬 전 ==");
        printData(arr);
        System.out.println("== 정렬 후 ==");
        printData(result.stream().mapToInt(x -> (int)x).toArray());
    }

    public static void printData(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println(arr[arr.length -1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);
    }


}
