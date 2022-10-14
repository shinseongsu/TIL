package programmers.course1.problem04;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();
        for (String[] clothing : clothes) {
            String type = clothing[1];
            closet.put(type, closet.getOrDefault(type, 0) + 1);
        }

        int combinations = 1;
        for (String clothingType : closet.keySet()) {
            combinations *= closet.get(clothingType) + 1;
        }

        return combinations - 1;
    }
}
