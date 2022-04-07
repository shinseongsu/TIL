public class Main {

    public static void main(String[] args) {

        int dan = 6;

        for(int i = 1 ; i <= 9 ; i++) {

            if(i == 4) {
                continue;
            }

            if(i == 6) {
                break;
            }

            System.out.println(dan + " x " + i + " = " + (dan * i));
        }

    }

}
