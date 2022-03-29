package chapter02;

public class Main {
    public static void main(String[] args) {

        // 1. 비트 논리 연ㅅ나자
        System.out.println("== 비트 논리 연산자 ==");

        // 1.1 AND 연산자 (&)
        System.out.println("=== & ==");
        int num1 = 5;
        int num2 = 3;
        int result = 0;

        result = num1 & num2;
        System.out.println("result = " + result);
        System.out.println(Integer.toBinaryString(num1));

        // printf(%04d ) ->   4자리 숫자를 표시한다. 다 차지 않으면 0으로 채우기
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));


        // 1.2 OR 연산자 (|)
        System.out.println("== | ===");

        result = num1 | num2;
        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 1.3 XOR 연산자
        System.out.println("== XOR ==");

        result = num1 ^ num2;
        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));

        // 1.4 반전 연산자(~)
        System.out.println("== ~ ==");
        num1 = 5;

        result = ~num1;
        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%s\n", Integer.toBinaryString(result));


        // 2. 비트 이동 연산자
        System.out.println("== 비트 이동 연산자 ==");


        // 2.1 << 연산자
        System.out.println("== << 연산자 ==");
        int numA = 3;

        result = numA << 1;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));


        // 2.2 >> 연산자
        System.out.println("== >> 연산자 ==");
        result = numA >> 1;

        System.out.println("result = " + result);
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n", Integer.parseInt(Integer.toBinaryString(result)));


        // 2.3 >>> 연산자
        System.out.println("== >>> 연산자 ==");

        numA = -5;

        result = numA >> 1;
        System.out.printf("%s\n", Integer.toBinaryString(numA));
        System.out.printf("%s\n", Integer.toBinaryString(result));

        result = numA >>> 1;
        System.out.printf("%s\n", Integer.toBinaryString(numA));
        System.out.printf("%s\n", Integer.toBinaryString(result));


    }
}
