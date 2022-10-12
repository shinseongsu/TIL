package week2;

public class Solution4 {

    public int solution (int delay, int capacity, int[] times) {
        int currentTime = 0;
        int currentQueue = 0;
        int result = 0;
        for (int time: times) {
            currentTime += time;
            int sent = currentTime / delay;
            currentQueue = Math.max(0, currentQueue - sent);
            if (currentQueue == capacity) {
                result++;
            } else {
                currentQueue++;
            }
            currentTime %= delay;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.solution(5, 5, new int[] { 3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5 }));
    }

}
