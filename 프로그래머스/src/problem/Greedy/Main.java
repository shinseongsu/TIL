package problem.Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 효율성 시간 초과
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        Queue<Integer> sq = new LinkedList<>();
        for(int s : stations) sq.offer(s);

        int position = 1;
        while(position <= n) {
            if(!sq.isEmpty() && sq.peek() - w <= position) {
                position = sq.poll() + w + 1;
            } else {
                answer += 1;
                position += w*2 +1;
            }
        }
        return answer;
    }

    public int solution1(int n, int[] stations, int w) {
        int answer = 0;

        int si = 0;

        int position = 1;
        while(position <= n) {
            if(si < stations.length && stations[si] - w <= position) {
                position = stations[si] + w + 1;
                si++;
            } else {
                answer += 1;
                position += w*2 +1;
            }
        }
        return answer;
    }

    // TIP. 효율성 높이기
    // 1. LOOP 개선
    // 2. 적절한 데이터 구조 사용
    // 3. 불필요한 오브젝트 제거
}
