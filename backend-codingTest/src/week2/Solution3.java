package week2;

public class Solution3 {

    int i = 0;

    public String solution(String code) {
        return recursive(code);
    }

    public String recursive(String s)
    {
        StringBuilder sb = new StringBuilder();
        String temp;

        int num = 0;

        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                num = Character.getNumericValue(s.charAt(i));
                i++;
            } else if(s.charAt(i)=='{') {
                i++;
                temp = recursive(s);
                sb.append(temp.repeat(num));
            } else if(s.charAt(i)=='}') {
                i++;
                break;
            }
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution("5{he2{l}o}friend"));
    }

}
