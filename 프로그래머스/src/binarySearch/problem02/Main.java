package binarySearch.problem02;

public class Main {
    boolean solution(String s) {
        String s2 = s.toLowerCase();
        int p = 0;
        for(char c : s2.toCharArray()) if (c == 'p') p++;
        for(char c : s2.toCharArray()) if (c == 'y') p--;
        return p == 0;
    }

    boolean solution2(String s) {
        int p = s.replaceAll("[^pP]", "").length();
        int y = s.replaceAll("[^yY]", "").length();
        return p == y;
    }

}
