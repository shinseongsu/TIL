package programmers.course2.problem06;

public class Solution {
    public int solution(int[][] sizes) {
        int larger = 0, smaller = 0;
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            larger = Math.max(larger, Math.max(width, height));
            smaller = Math.max(smaller, Math.min(width, height));
        }
        return larger * smaller;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution( new int[][] { {60, 50}, {30, 70}, {60, 30}, {80, 40} } ));
    }

}
