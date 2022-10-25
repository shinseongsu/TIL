package programmers.course4.problem02;

import java.util.*;

public class Solution {
    public String solution(String number, int k) {
        Stack<Character> digits = new Stack<>(); // O(n - k) 공간
        int canRemove = k;
        for (int i = 0; i < number.length(); i++) { // O(n + k) 시간
            char currentDigit = number.charAt(i);
            while (!digits.isEmpty() && currentDigit > digits.peek() && canRemove > 0) {
                digits.pop();
                canRemove--;
            }
            digits.push(currentDigit);
        }

        char[] maxNumber = new char[number.length() - k]; // O(n - k) 공간
        for (int i = 0; i < maxNumber.length; i++) {
            maxNumber[i] = digits.get(i);
        }
        return String.valueOf(maxNumber);
    }
}
