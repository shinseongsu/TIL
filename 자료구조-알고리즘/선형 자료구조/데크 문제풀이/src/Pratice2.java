import java.util.ArrayDeque;
import java.util.Deque;

// 팰린드롬 찾기
// 앞으로 읽거나 뒤로 읽어도 같은 문자열
public class Pratice2 {
    public static boolean checkPalindrome(String str) {
        Deque deque = new ArrayDeque();
        boolean isFront = true;
        boolean isPallindrome = true;

        for (String s: str.split("")) {
            deque.addFirst(s);
        }

        while (!deque.isEmpty()) {
            String s1 = (String) deque.pollFirst();
            String s2 = (String) deque.pollLast();

            if (s1 != null && s2 != null && !s1.equals(s2)) {
                isPallindrome = false;
                break;
            }
        }

        return isPallindrome;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abcba"));
        System.out.println(checkPalindrome("abccba"));
    }

}
