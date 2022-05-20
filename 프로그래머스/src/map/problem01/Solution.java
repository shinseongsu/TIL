package map.problem01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int solution(int[] nums) {
        // [3,3,3,2,2,2]
        // [3,2] : 3개
        // N/2 : 3개
        // 폰켓몬의 종류의 개수를 구한다.
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, 0);
        }
        int n1 = map.keySet().size();

        // 배열의 크기의 1/2 을 구한다.
        int n2 = nums.length / 2;

        // 최소값을 선택한다.
        return Math.min(n1, n2);
    }

    public int soltion2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, 0);
        }
        return Math.min(map.keySet().size(), nums.length / 2);
    }

}
