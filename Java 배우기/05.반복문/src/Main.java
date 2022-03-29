public class Main {

    public static void main(String[] args) {

        // 1. 반복문 - for
        System.out.println("== for ==");

        // 1.1 기본 사용 방법
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println("== 번쪽 삼각형 만들기 ===");

        for(int i = 0; i < 5 ; i++) {
            for(int j = 0 ; j < i + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println("== continue 사용하기 ==");
        for(int i = 0; i < 5 ; i++) {
            if(i == 2) {
                continue;
            }

            for(int j = 0 ; j < i + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println("== break 사용하기 ==");
        for(int i = 0; i < 5 ; i++) {
            if(i == 2) {
                break;
            }

            for(int j = 0 ; j < i + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        // 1.2 for Each (향상된 for문)
        System.out.println("== forEach ==");
        int[] nums = {1,2,3,4,5};

        // 일반 for 문
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();

        // forEach
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println();


        // 2. 반복문 - while
        System.out.println("== while ==");

        // 2.1 while
        int i = 0;
        while(i < 5) {
            System.out.println(i++);
        }

        System.out.println();
        i = 0;
        while(i < 5) {
            if(i == 2) {
                i++;
                continue;
            }
            System.out.println(i++);
        }

        System.out.println();
        i = 0;
        while(i < 5) {
            if(i == 2) {
                i++;
                break;
            }
            System.out.println(i++);
        }


        // 2-2 do-while
        // 무조건 한번은 실행
        System.out.println("== do-while ==");
        boolean knock = false;

        do {
            System.out.println("knock");
        } while (knock);


        System.out.println();
        // Q1. 아래와 같은 출력 결과를 반복문과 조건문을 이용하여 출력해보세요.
        // *
        // ***
        // *****
        // *******
        for(int i = 0 ; i < 8 ; i++) {
            if(i % 2 == 0) continue;

            for(int j = 0 ; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        // Q2. 반복문을 실행할 때마다 물 온도를 1도씩 올리고 100도가 되면 종료된다.
        // 추가로 10도, 20도, ... 10도 간격으로 물 온도를 출력하시오.
        int waterTemperature = 0;

        while(waterTemperature < 100) {
            waterTemperature++;

            if(waterTemperature % 10 == 0) {
                System.out.println(waterTemperature + " 도 입니다.");
            }
        }

    }

}
