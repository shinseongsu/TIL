package chap01;

public class LanbdaEx01 {
    public static void main(String[] args) {
        // 기존 자바
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal Run Thread.");
            }
        }).start();

        // 람다식
        new Thread(() -> {
            System.out.println("Lambda run...");
        }).start();
    }
}
