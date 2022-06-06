package map.problem03;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        // 위장용품의 종류별 개수를 구한다.
        for(String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 각 개수의 +1를 모두 곱한다.
        int answer = 1;
        var iter = map.values().iterator();
        while (iter.hasNext()) {
            answer *= iter.next() + 1;
        }

        // -1 해서 리턴한다.
        return answer - 1;
    }

}
