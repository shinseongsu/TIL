package programmers.course1.problem03;

import java.util.HashMap;
import java.util.Map;


// 시간 복잡도 : O (n)
public class Solution {
    public String solution(String[] participants, String[] completion) {
        Map<String, Integer> completed = new HashMap<>();
        for (String participant : completion) {
            completed.put(participant, completed.getOrDefault(participant, 0) + 1);
        }
        for (String participant : participants) {
            if (!completed.containsKey(participant) || completed.get(participant) == 0) {
                return participant;
            }
            completed.put(participant, completed.get(participant) - 1);
        }
        return "";
    }
}
