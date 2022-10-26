package programmers.course3.problem07;

public class Solution {

    boolean[] visited;
    int value = 51;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        backTracking(begin, target, words, 0);

        if (value == 51) {
            return 0;
        }

        return value;
    }

    public void backTracking(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            value = Math.min(value, depth);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                backTracking(words[i], target, words, depth + 1);
                visited[i] = false;
            }

        }
    }

    public boolean check(String begin, String target) {
        int count = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == target.charAt(i)) {
                count++;
            }
        }

        if (count == begin.length() - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.solution( "hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" } ) );
    }

}
