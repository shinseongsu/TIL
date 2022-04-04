package practice02;

public class Main {

    public static String solution(int num) {
        String result = "";

        String[] roman =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values   =  {1300, 900, 500, 400, 100,  90,   50,   40,   10,  9,    5,    4,   1};

        int i = 0;
        while(num > 0) {
            while(num >= values[i]) {
                num -= values[i];
                result += roman[i];
            }
            i++;
        }

        return result;
    }


    public static void main(String[] args) {
        // Test Code
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));

    }
}
