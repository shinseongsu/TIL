package practice05;

public class Main {
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int result = 1;
        int upCnt = 1;
        int downCnt = 0;
        int peak = 0;
        for (int i = 1; i < ratings.length; i++) {
            // 다음 순번의 rating 이 더 높은 경우, upCnt 증가, peak 갱신, downCnt 쪽은 0으로 초기화
            if (ratings[i] > ratings[i - 1]) {
                upCnt++;
                peak = upCnt;
                downCnt = 0;
                result += upCnt;
            } else if (ratings[i] == ratings[i - 1]) {
                // 다음 순번과 rating 이 같은 경우는 1 개 주면 됨
                // upCnt 는 1로, downCnt 와 peak 는 0으로 초기화
                upCnt = 1;
                downCnt = 0;
                peak = 0;
                result += 1;
            } else {
                // 다음 순번의 rating 이 낮은 경우, downCnt 증가, upCnt 쪽은 1로 초기화
                downCnt++;
                upCnt = 1;
                result += downCnt;
                // rating 이 낮은 쪽으로 진행되다가 앞의 peak 를 넘어선 경우 1 씩 더해줌
                if (peak <= downCnt) {
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
