// 단방향 연결 리스트에서 출력 데이터를 찾아 삭제하세요

// 입출력 예시 )
// 입력 연결 리스트: 1, 3, 3, 1, 4, 2, 4, 2
// 겱과 연결 리스트: 1, 3, 4, 2

class Node {
    int data;
    Node next;

    Node() { }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() { }
    LinkedList(Node node) { this.head = node; }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public boolean findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
              //  System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
    //    System.out.println("Data not found!");
        return false;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class Problem01 {

    public static LinkedList removeDup(LinkedList listBefore) {
        LinkedList listAfter = new LinkedList();

        Node cur = listBefore.head;
        while (cur != null) {
            if (listAfter.findData(cur.data) == false) {
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }

    public static void main(String[] args) {
        // Test code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData();

        linkedList = removeDup(linkedList);
        linkedList.showData();
    }

}
