public class Pratice2 {

    static int gcd(int a, int b) {
        if( a % b == 0 ){
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        // TestCode
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
    }

}
