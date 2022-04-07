public class Main {

    public static void main(String[] args) {

        int i1 = 10;
        int i2 = 20;
        long l2 = 20L;

        boolean result = i1 > i2;
        boolean result2 = i1 == i2;
        boolean result3 = i2 == l2;

        System.out.println(result);  // true
        System.out.println(result2); // false
        System.out.println(result3); // true

        System.out.println(i1 > i2);
        System.out.println(i1 >= i2);
        System.out.println(i1 < i2);
        System.out.println(i1 <= i2);
        System.out.println(i1 == i2);
        System.out.println(i1 != i2);

    }

}
