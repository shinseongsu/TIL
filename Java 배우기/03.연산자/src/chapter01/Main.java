package chapter01;

public class Main {
    public static void main(String[] args) {

        // 1. 대입 연산, 부호 연산자
        int num = 100;
        num = +10;
        num = 10;
        num = -10;

        // 2. 산술연산자, 증가/감소 연산자
        System.out.println("== 산술 연산자, 증가/감소 연산자 ==");
        int numX = 10;
        int numY = 3;
        int result = 0;
        result = numX + numY;
        result = numX - numY;
        result = numX * numY;
        result = numX / numY;
        result = numX % numY;
        System.out.println("result = " + result);

        int num2 = 1;
        System.out.println(num2++);
        System.out.println(num2);

        num2 = 1;
        System.out.println(++num2);
        System.out.println(num2);

        num2 = 1;
        System.out.println(num2--);
        System.out.println(num2);

        num2 = 1;
        System.out.println(--num2);
        System.out.println(num2);


        // 3. 관계 연산자
        System.out.println("== 관계 연산자 ==");
        int numA = 10;
        int numB =  9;

        System.out.println(numA > numB);
        System.out.println(numA < numB);
        System.out.println(numA == numB);
        System.out.println(numA != numB);


        // 4. 논리연산자
        System.out.println("== 논리 연산자 ==");
        System.out.println((10 > 9) && (1 == 0));
        System.out.println((10 > 9) || (1 == 0));


        // 5. 복합 대입 연산자
        System.out.println("-- 복합 대입 연산자 ==");
        int num1 = 10;
        int num3 = 5;
        num1 += num3;
        // num1 = num1 + num3;
        System.out.println("num3 = " + num3);


        // 빼기 예제
        num1 -= num3;


        // 6. 삼항 연산자
        System.out.println("== 삼항 연산자 ==");
        int a = 100;
        String aResult = (a == 100) ? "yes" : "no";
        System.out.println("aResult = " + aResult);

    }
}
