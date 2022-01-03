package chap02;

// 함수형 인터페이스
@FunctionalInterface
interface MyFunction1 {
    int calc(int x);
}

@FunctionalInterface
interface MyFunction2 {
    int calc(int x, int y);
}

public class LambdaEx02 {
    public LambdaEx02() {
        // 매개변수가 1개인 람다식
        MyFunction1 result1 = (x) -> { return x + x; };
        MyFunction1 result2 = x -> x + x;
        System.out.println("result1의 결과: " + result1.calc(5));
        System.out.println("result2의 결과: " + result2.calc(5));

        // 매개변수가 2개인 람다식
        MyFunction2 add = (x, y) -> { return x + y; };
        MyFunction2 minus = (x, y) -> x - y;
        System.out.println("add 결과: " + add.calc(3, 5));
        System.out.println("minus 결과: " + minus.calc(3, 5));

        MyFunction2 f = new MyFunction2() {
            @Override
            public int calc(int x, int y) { return x + y; }
        };

        int value = f.calc(5, 3);
        System.out.println("value 결과: " + value);

        MyFunction2 f2 = (a, b) -> a > b ? a : b;
        value = f2.calc(3, 2);
        System.out.println("value 결과: " + value);
    }

    public static void main(String[] args) { new LambdaEx02(); }

}
