public class Main3 {

    public static void main(String[] args) {

        char c1 = ' ';
        char c2 = '\0';
        char c3 = '\u0000';

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);

    }

}
