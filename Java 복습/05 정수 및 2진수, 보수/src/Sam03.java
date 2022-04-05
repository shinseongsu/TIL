public class Sam03 {

    public static void main(String[] args) {

        int i1 = 0b0000_0000_0000_0000_0000_0000_0000_0001_0101;    // 21
        int i2 = 0b1111_1111_1111_1111_1111_1111_1111_1110_1011;    // -21 (21의 2의 보수)

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i1 + i2);    // 0


        int j1 = 0b0101_1111_1010_0000_1100_1111_0101_0101;
        int j2 = 0b1010_0000_0101_1111_0011_0000_1010_1011;

        System.out.println(j1); //  1604374357
        System.out.println(j2); // -1604374357

    }

}
