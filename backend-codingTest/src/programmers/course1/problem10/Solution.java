package programmers.course1.problem10;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<Character> openingBrackets = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(') {
                openingBrackets.push(bracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    return false;
                }
                openingBrackets.pop();
            }
        }
        return openingBrackets.isEmpty();
    }
}
