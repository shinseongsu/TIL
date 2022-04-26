package bronze5.problem15894;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        BigInteger recting = sc.nextBigInteger();

        System.out.println(recting.multiply(new BigInteger("4")));

    }
}
