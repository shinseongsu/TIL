package bronze5.problem8437;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger total = sc.nextBigInteger();
        BigInteger diff  = sc.nextBigInteger();
        BigInteger two = new BigInteger("2");

        System.out.println( total.subtract(diff).divide(two).add(diff) );
        System.out.println( total.subtract(diff).divide(two) );
    }
}
