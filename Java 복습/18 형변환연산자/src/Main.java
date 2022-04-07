public class Main {

    public static void main(String[] args) {

        double d1 = 10.0d;
        System.out.println(d1);

        for(int i = 0 ; i < 10 ; i++) {
            d1 += 0.1;
            System.out.printf("%5.2f", d1);
        }
        System.out.println();

        System.out.println("------------------");

        short s10 = 10;
        short s20 = 20;
        int s30 = s10 + s20;
        System.out.println("s30 = " + s30);

    }
}
