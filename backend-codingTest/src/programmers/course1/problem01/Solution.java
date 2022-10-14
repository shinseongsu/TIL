package programmers.course1.problem01;

import java.util.HashSet;
import java.util.Set;

// 시간복잡도 : O(n)
public class Solution {
    public int solution(int[] nums) {
        int limit = nums.length / 2;
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        return Math.min(uniqueNums.size(), limit);
    }
}
