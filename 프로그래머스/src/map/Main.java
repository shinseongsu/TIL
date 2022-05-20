package map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

// Arrray 장점 + List 장점 => 유연하면서 빠르게 값을 찾아낼 수 있는
// Map : Key -> hash function -> hash -> bucket index -> List -> Data

// Map<K, V>
// HashMap -> not Synchorize
// HashTable -> Synchorize
// ConcurentHashMap : synchorize + hish concurrrency

class Mydata {
    int v;

    public Mydata(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "[" + v + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydata mydata = (Mydata) o;
        return v == mydata.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.putIfAbsent("A", 10);
        map.replace("A", 1, 10);

        mehtod1(map);

        Map<Mydata, Integer> map2 = new Hashtable<>();
        map2.put(new Mydata(1), 1);
        map2.put(new Mydata(1), 2);
        map2.replace(new Mydata(1), 1, 11);

        method2(map2);
    }

    static void method2(Map<Mydata, Integer> map) {
        System.out.println(map.values());
        System.out.println(map.keySet());
    }

    static void mehtod1(Map<String, Integer> map) {

        System.out.println(map.remove("B", 2));
        System.out.println(map);
        System.out.println(map.get("A"));
        System.out.println(map.getOrDefault("C", -1));
        System.out.println(map.values());
        System.out.println(map.keySet());
    }
}