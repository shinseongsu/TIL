package chap02;

public class LambdaEx03 {

    @FunctionalInterface
    interface MyFunction3 {
        void print();
    }

    public LambdaEx03() {
        // 파라미터가 없는 람다식
        MyFunction3 result = () -> { System.out.println("print..."); };
        result.print();
    }

    public static void main(String[] args) { new LambdaEx03(); }

}
