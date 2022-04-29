package ArrayList.basic;

import java.util.*;

class MyData {
    int value;

    public MyData(int value) {
        this.value = value;
    }

    static MyData create(int v) {
        return new MyData(v);
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        list.remove(2);

        System.out.println(list.contains(Integer.valueOf(5)));

        System.out.println("==  Custom List  ==");
        // Custom List //
        LinkedList<MyData> myList = new LinkedList<>();
        myList.add(MyData.create(1));
        myList.add(MyData.create(2));
        myList.add(MyData.create(3));

        System.out.println(myList);
        System.out.println(myList.contains(MyData.create(2)));

        System.out.println(myList.indexOf(MyData.create(3)));

        System.out.println("==  Vector  ==");
        // Vector //
        // 이것도 array로 되어 있다.
        // synchronized - o (동기화 기능 동작)
        List<MyData> vectorList = new Vector<>();
        vectorList.add(MyData.create(1));
        vectorList.add(MyData.create(2));
        vectorList.add(MyData.create(3));

        System.out.println(vectorList.size());
        System.out.println(vectorList.isEmpty());
        method(vectorList);

        System.out.println("==  ArrayList  ==");
        // ArrayList //
        // 사이즈가 추가되면 더 큰 배열을 만들어 기존의 값을 옮긴다.
        // synchronized - x (동기화 기능 없음)
        List<MyData> arrayList = new ArrayList<>(10);
        arrayList.add(MyData.create(1));
        arrayList.add(MyData.create(2));
        arrayList.add(MyData.create(3));

        System.out.println(arrayList);
        System.out.println(arrayList.get(2));
        method(arrayList);
    }

    static void method(List<MyData> list) {
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }

}
