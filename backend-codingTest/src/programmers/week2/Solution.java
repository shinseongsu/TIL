package programmers.week2;

public class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자 -> 내림차순정렬 -> 조합
        String[] strNums = new String[numbers.length];

        for(int i = 0; i < numbers.length ; i++) {
            strNums[i] = "" + numbers[i];
        }

        for(int i = 0 ; i < strNums.length-1 ; i++) {
            for(int j = i+1 ; j < strNums.length ; j++) {
                String s1 = strNums[i];
                String s2 = strNums[j];

                if((s1+s2).compareTo(s2+s1) < 0) {
                    strNums[i] = strNums[j];
                    strNums[j] = s1;
                }
            }
        }

        String answer = "";
        for (String s: strNums) {
            answer += s;
        }

        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
