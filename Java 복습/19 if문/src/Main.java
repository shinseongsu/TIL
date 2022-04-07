public class Main {
    public static void main(String[] args) {

        int age = 25;
        String item = "";
        String subItem = "";

        System.out.println("조건 시작!");

        // 성인인지 확인
        if (age > 19)
            item = "아이템1";        // if 조건문의 스코프는 ;(세미콜론을 만나면 끝난다) 그렇지 때문에 {} 를 사용해서 진행해야 한다.
        subItem = " 서브아이템1";

        System.out.println("조건끝!");
        System.out.println("item: " + item);
        System.out.println("subItem = " + subItem);
    }
}
