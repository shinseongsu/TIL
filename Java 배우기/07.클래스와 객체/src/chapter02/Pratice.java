package chapter02;

class Caluclator {

    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double sum(String a, String b) {
        return Double.parseDouble(a) + Double.parseDouble(b);
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

}

public class Pratice {
    public static void main(String[] args) {
        // Test Code
        Caluclator c = new Caluclator();
        System.out.println(c.sum(1, 2));;
        System.out.println(c.sum(1.0, 2.0));
        System.out.println(c.sum("1", "2"));
        System.out.println(c.sum(1, 2, 3));

    }
}
