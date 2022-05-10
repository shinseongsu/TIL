// 연결리스트 배열 사용 연습

// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기

import java.util.HashSet;

class Node1 {
    String data;
    Node1 next;

    Node1() { }
    Node1(String data, Node1 next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList1 {
    Node1 head;
    char alphabet;

    LinkedList1() {}
    LinkedList1(Node1 node, char alphabet) {
        this.head = head;
        this.alphabet = alphabet;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(String data) {
        if (this.head == null) {
            this.head = new Node1(data, null);
        } else {
            Node1 cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node1(data, null);
        }
    }

    public void removeData(String data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node1 cur = this.head;
        Node1 pre = cur;
        while (cur != null) {
            if (cur.data.equals(data)) {
                if(cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            }
            break;
        }

        pre = cur;
        cur = cur.next;
    }

    public boolean findData(String data) {
        if (this.isEmpty()) {
            System.out.println("List is mepty");
            return false;
        }

        Node1 cur = this.head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return false;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node1 cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + ' ');
            cur = cur.next;
        }
        System.out.println();
    }

}


public class Problem04 {

    public static void dataCollect(String[] data) {
        HashSet<Character> set = new HashSet();

        for (String item: data) {
            set.add(item.toCharArray()[0]);
        }
        System.out.println(set);

        Character[] arr = set.toArray(new Character[0]);
        LinkedList1[] linkedList = new LinkedList1[set.size()];

        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList1(null, arr[i]);
        }

        for (String item: data) {
            for (LinkedList1 list: linkedList) {
                if (list.alphabet == item.toCharArray()[0]) {
                    list.addData(item);
                }
            }
        }

        for (LinkedList1 list: linkedList) {
            System.out.print(list.alphabet + " : ");
            list.showData();
        }

    }

    public static void main(String[] args) {
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry", "orange"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab", "chicken"};
        dataCollect(input2);


    }


}
