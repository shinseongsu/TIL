// 괄호 짝 검사

// 입력 "("
// 출력: fail

// 입력 ")"
// 출력 fail

// 입력 "()"
// 출력 Pass

import java.util.Stack;

public class Pratice2 {
    public static void chunkParenthesis(String str) {
        Stack stack = new Stack();
        boolean checkFlag = true;

        for (String s: str.split("")) {
            if(s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    checkFlag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (checkFlag && stack.isEmpty()) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }

    }

    public static void main(String[] args) {
        chunkParenthesis("(");
        chunkParenthesis(")");
        chunkParenthesis("()");
        chunkParenthesis("()()()");
        chunkParenthesis("(())()");
        chunkParenthesis("((()))");

    }

}
