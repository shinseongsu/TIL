package set.problem03;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();

        int last = -1;
        for(int a: arr) {
            if(last == a) continue;
            last = a;
            list.add(a);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
