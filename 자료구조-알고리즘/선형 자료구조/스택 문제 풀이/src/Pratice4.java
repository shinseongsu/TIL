
// 문자열 비교
// 단 #는 backspace로 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입력 s1 = "tree", s2 = "th#ree"
// 출력 true

// 입력 s1 = "ab#a" , s2 = "aab#"
// 출력 true

import java.util.Stack;

public class Pratice4 {
    public static boolean stringCompare(String s1, String s2) {
        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);
        return s1After.equals(s2After);
    }

    public static String doBackspace(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#a";
        s2 = "wo#o";
        System.out.println(stringCompare(s1, s2));
    }

}
