package tree.problem01;

import java.util.*;

public class Main {
    public int soluution(int[] scoville, int k) {
        List<Integer> list = new LinkedList<>();
        for (int s : scoville) list.add(s);

        Collections.sort(list);
        int answer = 0;

        while( list.size() >= 2 && list.get(0) < k ) {
            int s1 = list.remove(0);
            int s2 = list.remove(0);
            int s3 = s1 + s2*2;
            list.add(s3);
            answer++;

            Collections.sort(list);
        }

        if(list.get(0) < k) return -1;

        return answer;
    }

    public int solution2(int[] scoville, int k) {
        Queue<Integer> list = new PriorityQueue<>();
        for(int s : scoville) list.offer(s);

        int answer = 0;

        while( list.size() >= 2 && list.peek() < k ) {
            int s1 = list.poll();
            int s2 = list.poll();
            int s3 = s1 + s2*2;
            list.offer(s3);
            answer++;
        }

        if(list.peek() < k) return -1;

        return answer;

    }

}
