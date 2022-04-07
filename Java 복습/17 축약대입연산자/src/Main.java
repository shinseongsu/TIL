public class Main {
    public static void main(String[] args) {

        int i1 = 0b0000_0000_0000_0000_0000_0000_0000_0001_0100;
        i1 <<= 3;

        System.out.println(i1);

        int a = 10;
        int b = 20;
        a += b;
        a = a + b;

        System.out.println(a);

    }
}
