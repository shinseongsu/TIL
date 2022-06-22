package sort.problem03;

public class Main {
    public String solution(String s) {
        String answer = "";
        String s2 = s.toLowerCase();
        char last = ' ';
        for (char c : s2.toCharArray()) {
            if (last == ' ') c = Character.toUpperCase(c);
            answer += c;
            last = c;
        }
        return answer;
    }

    public String solution2(String s) {
        StringBuilder sb = new StringBuilder();

        String s2 = s.toLowerCase();
        char last = ' ';
        for (char c : s2.toCharArray()) {
            if(last == ' ') c = Character.toUpperCase(c);
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }

}
