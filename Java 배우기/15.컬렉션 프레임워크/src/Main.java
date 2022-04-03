import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1.List

        // 1.1 ArrayList
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("list1 = " + list1);

        list1.remove(Integer.valueOf(2));
        System.out.println("list1 = " + list1);
        list1.add(0, 10);

        System.out.println("list1 = " + list1);
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.contains(1) = " + list1.contains(1));
        System.out.println("list1.indexOf(10) = " + list1.indexOf(10));

        // 1-2. LinkedList
        System.out.println("== LinkedList ==");
        LinkedList list2 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        System.out.println("list2 = " + list2);
        list2.addFirst(10);
        list2.addLast(20);
        System.out.println("list2 = " + list2);
        list2.remove(Integer.valueOf(1));
        System.out.println("list2 = " + list2);
        list2.removeFirst();
        list2.removeLast();
        System.out.println("list2 = " + list2);
        System.out.println("list2.size() = " + list2.size());

        // 2. Set
        // 2-1. HashSet
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        System.out.println("set1.size() = " + set1.size());
        System.out.println(set1.contains(2));


        // 2-2 TreeSet
        System.out.println("== TreeSet ==");
        TreeSet set2 = new TreeSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println("set2 = " + set2);
        set2.remove(2);
        System.out.println("set2 = " + set2);
        set2.clear();
        System.out.println("set2 = " + set2);
        set2.add(10);
        set2.add(5);
        set2.add(15);
        set2.add(15);
        System.out.println("set2 = " + set2);
        System.out.println(set2.first());
        System.out.println(set2.last());
        System.out.println(set2.lower(10));     // 10보다 작은 거 모두 출력
        System.out.println(set2.higher(10));    // 10보다 큰 거 모두 출력


        // 3. Map
        // 3-1 HashMap
        System.out.println("== HashMap ==");
        HashMap map1 = new HashMap();
        map1.put(1, "kiwi");
        map1.put(2, "apple");
        map1.put(3, "mango");
        System.out.println("map1 = " + map1);

        map1.remove(2);
        System.out.println("map1 = " + map1);
        System.out.println("map1.get(1) = " + map1.get(1));


        // 3-2 TreeMap
        System.out.println("== TreeMap ==");
        TreeMap map2 = new TreeMap();
        map2.put(10, "kiwi");
        map2.put(5, "apple");
        map2.put(15, "mango");
        System.out.println("map2 = " + map2);

        System.out.println(map2.firstEntry());
        System.out.println(map2.firstKey());
        System.out.println(map2.lastEntry());
        System.out.println(map2.lastKey());
        System.out.println(map2.lowerEntry(10));
        System.out.println(map2.higherEntry(10));


    }
}
