package sort.problem02;

import java.util.Arrays;

public class Main {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }
}
