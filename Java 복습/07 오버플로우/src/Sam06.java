public class Sam06 {

    public static void main(String[] args) {

        int iMax = 0x7f_ff_ff_ff;
        int iMax2 = Integer.MAX_VALUE;

        int i1 = 0b01111_1111_1111_1111_1111_1111_1111_1111;
        // int i2 = 0b1000_0000_0000_0000_0000_0000_0000_0000;
        // -2 ^ 31 ~ 2 ^ 31 -1
        // 0 때문에 양수가 하나 더 적다.

        int i3 = 0b0000_0000_0000_0000_0000_0000_0000_0001;
        int i4 = 0b1000_0000_0000_0000_0000_0000_0000_0000;
        int i5 = i4 - 1;

        System.out.println(iMax);       // 2147483647  ( 최대값 )
        System.out.println(i4);         // -2147483648 ( 최솟값 )
        System.out.println(i1 + i3);    // 0
        System.out.println(i5);         // 2147483647


    }

}
