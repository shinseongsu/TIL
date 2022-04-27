package problem04;

// 문제 풀이 방식이 생각이 안나면 포기해야 할까요?
// 다른 문제로 시간 안배후, 다시 푼다.
// 공부할떄는 30분 후, 답안을 본다.
public class Main {
    public int solution(int n, int i, int j) {
        return recursion(0, n , i , j);
    }

    private int recursion(int count, int n, int i, int j) {
        // n=2인 경우 (2x2) 탈출조건
        if(n == 2) {
            if(i == 0 & j == 1) {
                return count +1;
            } else if (i == 0 & j == 0) {
                return count + 2;
            } else if (i == 1 & j == 0) {
                return count + 3;
            } else {
                return count + 4;
            }
        }

        // 4개 영역으로 나누어 count offset 계산. 해당 영역 내의 부분 i,j로 변환
        int m = n / 2;
        if (i < m & j >= m) {   // 우측 상단
            return recursion(count, m, i, j - m);
        }
        else if (i < m & j < m) {   // 좌측 상단
            count += m * m;
            return recursion(count, m, i, j);
        }
        else if (i >= m & j < m) {  // 좌측 하단
            count += m * m * 2;
            return recursion(count, m, i - m, j);
        }
        else {
            count += m * m * 3;     // 우측 하단
            return recursion(count, m, i - m, j -m);
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution(4, 1, 4));
    }

}
