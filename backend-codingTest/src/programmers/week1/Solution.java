package programmers.week1;

public class Solution {

    // 프리미 타입 쓰기
    // for 반복문 개선
    // 불필요한 오브젝트 제거
    public int solution(int n, int[] stations, int w) {
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

}
