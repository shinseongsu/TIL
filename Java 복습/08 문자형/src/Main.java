public class Main {

    public static void main(String[] args) {

        // 문자형

        char c1 = '\ubc15';  // 박
        char c2 = '\uaddc';  // 규

        // System.out.println(c1);
        // System.out.println(c2);

        char startValue = Character.MIN_VALUE;
        char endValue = Character.MAX_VALUE;

        char koStart = '\uAC00';
        char koEnd = '\uD7AF';

        // 한글만 출력하는 로직
        for(int i = startValue ; i <=endValue ; i++) {
            if(i >= (int) koStart && i <= (int) koEnd) {
                char charset = (char) i;
                System.out.println(charset);
            }
        }

    }

}
