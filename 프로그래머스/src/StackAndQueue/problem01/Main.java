package StackAndQueue.problem01;

import java.util.Stack;

public class Main {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() == true;
    }

    // 다른 방법
    boolean solution2(String s) {
        int stack = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') stack++;
            else {
                if (stack == 0) return false;
            }
        }
        return stack == 0;
    }

}
