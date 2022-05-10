
// 전위 / 중위 / 후위 표기법

// 입력 "2 2 +"
// 출력 4

// 입력 "2 2 -"
// 출력 0

import java.util.Stack;

public class Pratice3 {
    public static double calculate(String string) {
        Stack<Double> stack = new Stack();

        for (String str: string.split(" ")) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(str.equals("/")){
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(str));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));
    }

}
