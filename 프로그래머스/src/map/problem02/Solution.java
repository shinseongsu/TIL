package map.problem02;

import java.util.*;

public class Solution {

    // 시간 초과
    public String solution(String[] participant, String[] completion) {
        List<String> players = new LinkedList<>();

        for(String p : participant) players.add(p);
        for (String c: completion) players.remove(c);

        return players.get(0);
    }


    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> players = new HashMap<>();

        // O(n)
        for(String p : participant) {
            players.put(p, players.getOrDefault(p,0) + 1);
        }

        // O(n)
        for (String c: completion) {
            int n = players.get(c) - 1;
            if(n == 0) players.remove(c);
            else players.put(c, n);
        }

        return players.keySet().iterator().next();
    }


    public String solution3(String[] participant, String[] completion) {

        Arrays.sort(participant);   // O(nlogn)
        Arrays.sort(completion);    // O(nlogn)

        for(int i=0; i < completion.length; i++) {
            if(participant[i].equals(completion[i])) return participant[i];
        }

        return participant[participant.length-1];
    }


}
