public class Same02 {

    public static void main(String[] args) {

        // 편하게 볼 수 있게 _ 를 추가해서 넣을 수 있다.
        int i1 = 0b0000_0000_0000_0000_0000_0000_0000_0000_1100;
        int l2 = 0b000000000000000000000000000000001100;        // 가독성이 불편

        int i3 = -12;

        System.out.println(i1);
        System.out.println(i3);
        System.out.println(i1 + i3);


        int j1 = 0b0000_0000_0000_0000_0000_0000_0000_0000_0001;
        int j2 = 0b0000_0000_0000_0000_0000_0000_0000_0000_0001;
        //       0b0000_0000_0000_0000_0000_0000_0000_0000_0010;    결과
        int j3 = j1 + j2;

        System.out.println(j1);
        System.out.println(j2);
        System.out.println(j3);


        int j4   = 0b0000_0000_0000_0000_0000_0000_0000_0000_1100;
//        int j4_1 = 0b1111_1111_1111_1111_1111_1111_1111_1111_0011;    // j4에 대한 1의 보수//
//        int j4_2 = j4_1 + 1;                                          // j4에 대한 2의 보수 => j4에 대한 1의 보수 + 1
//        int j5   = 0b1111_1111_1111_1111_1111_1111_1111_1111_0100;    // j4 에 대한 2의 보수

    }


}
