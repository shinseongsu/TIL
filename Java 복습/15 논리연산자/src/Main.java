public class Main {

    public static void main(String[] args) {

        int i1 = 20;
        int i2 = 10;

        int j1 = 20;
        int j2 = 30;

        System.out.println(i1 < i2);    // false
        System.out.println(j1 < j2);    // true
        System.out.println((i1 < i2) && (j1 < j2)); // false
        System.out.println((i1 < i2) || (j1 < j2)); // true
        System.out.println((i1 < i2) ^ (j1 < j2));  // true
        System.out.println(!(i1 < i2));             // true

    }


}
