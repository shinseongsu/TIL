// 문자열 뒤집기

// 입력 : hello
// 출력 : olleh

import java.util.Stack;

public class Pratice1 {
    public static String reversString(String str) {
        Stack stack = new Stack();
        String result = "";

        for (String s: str.split("")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {

        String result = reversString("Hello");
        System.out.println("result = " + result);

        result = reversString("1 3 5 7 9");
        System.out.println("result = " + result);

    }

}
