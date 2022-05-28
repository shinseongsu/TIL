import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static int getHash(int key) {
        return key % 5;
    }


    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);

        for ( Map.Entry<String, Integer> item : ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        // 해시 충돌 케이스
        Hashtable<Integer, Integer> ht2 = new Hashtable<>();
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("== 충돌 전 ==");
        for (Map.Entry<Integer, Integer> item: ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        System.out.println("== 충돌 후 ==");
        ht2.put(getHash(6), 60);
        for (Map.Entry<Integer, Integer> item: ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

    }
}
