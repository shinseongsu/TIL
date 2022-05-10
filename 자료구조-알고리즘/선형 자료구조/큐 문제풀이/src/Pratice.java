// 카드 섞기

// 1부터 N 깢의 번호로 구성된 N장의 카드가 있다.
// 1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상대로 카드가 순서대로 쌓여 있다.

// 1. 가장 위의 카드는 버린다.
// 2. 그 다음 위의 카드는 방에 있는 카드의 가장 아래에 다시 넣는다.

// 입력 N = 4
// 출력 : 4

// N = 4
// 출력 : 6

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Pratice {
    public static int findLastCard(int N) {
        Queue queue = new LinkedList();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));
        System.out.println(queue);

        while (queue.size() > 1) {
            queue.remove();
            int data = (int) queue.remove();
            queue.add(data);
            System.out.println(queue);
        }

        return (int) queue.remove();
    }

    public static void main(String[] args) {
        System.out.println(findLastCard(4));
        System.out.println(findLastCard(7));
        System.out.println(findLastCard(9));
    }
}
