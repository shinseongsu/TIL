package problem07;

import java.util.Stack;

public class Main {
    public int[] solution(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = Math.max(a.length, b.length);
        int offsetA = maxLen - a.length;
        int offsetB = maxLen - b.length;

        if(a.length == 0) { return b; }
        if(b.length == 0) { return a; }

        int overflow = 0;  // 자리수 올림
        for (int i = maxLen - 1; i >= 0; i--) {
            int aVal = (i - offsetA < 0) ? 0 : a[i - offsetA];
            int bVal = (i - offsetB < 0) ? 0 : b[i - offsetB];
            int cVal = aVal + bVal + overflow;
            if (cVal >= 10) {
               overflow = 1;
               stack.push(cVal - 10);
            } else {
                overflow = 0;
                stack.push(cVal);
            }
        }

        int resLen = maxLen;
        if (overflow == 1) {
            resLen++;
            stack.push(1);
        }

        int[] result = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
