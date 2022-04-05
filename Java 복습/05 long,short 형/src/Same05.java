public class Same05 {

    public static void main(String[] args) {

        short s1 = 0b0000_0000_0000_1100;
        short s2 = (short) 0b1111_1111_1111_0100;

        System.out.println(s1); // 12
        System.out.println(s2); // -12

        // short s3 = s1 + s2;  // 에러.  short 두개를 더하면 int형으로 변환된다.

    }

}
