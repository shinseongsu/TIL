import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] str = {"홍길동", "이순신", "세종대왕"};

        for(int i = 0 ; i < str.length ; i++) {
            System.out.println(str[i]);
        }

        System.out.println("===============");

        // foreach
        for(String s : str) {
            System.out.println(s);
        }

        System.out.println("===============");
        Arrays.stream(str)
                .forEach(System.out::println);

    }

}
