// 데크 리사이즈

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size) {
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1)  % this.arr.length == this.front;
    }

    public void increaseSize() {
        int[] arrTemp = this.arr.clone();
        this.arr = new int[this.arr.length * 2];

        int start = (this.front + 1) % arrTemp.length;
        int end = (this.rear + 1) % arrTemp.length;

        int idx = 1;
        for (int i = start; i != end; i = (i +1) % arrTemp.length) {
            this.arr[idx++] = arrTemp[i];
        }

        this.front = 0;
        this.rear = idx - 1;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            increaseSize();
        }

        this.arr[front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if (this.isFull()) {
            increaseSize();
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public void addMiddle(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        int elements = this.rear - this.front;
        if (elements < 0) {
            elements = this.arr.length + elements;
        }

        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements /2 + this.arr.length) % this.arr.length;
        for (int i = start; i != end; i = (i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i +1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Pratice4 {
    public static void main(String[] args) {

        MyDeque2 myDeque2 = new MyDeque2(5);

        myDeque2.addLast(1);
        myDeque2.addLast(2);
        myDeque2.addLast(3);
        myDeque2.addLast(4);
        myDeque2.addLast(5);
        myDeque2.printDeque();

        myDeque2.addLast(6);
        myDeque2.addLast(7);
        myDeque2.addLast(8);
        myDeque2.addLast(9);
        myDeque2.addLast(10);
        myDeque2.printDeque();

        myDeque2.removeLast();
        myDeque2.removeLast();
        myDeque2.addFirst(100);
        myDeque2.addFirst(200);
        myDeque2.printDeque();

        myDeque2.addFirst(300);
        myDeque2.addFirst(400);
        myDeque2.addFirst(500);
        myDeque2.printDeque();




    }
}
