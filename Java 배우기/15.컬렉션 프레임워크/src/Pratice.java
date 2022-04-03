import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Pratice {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        for(int i = 0; set.size() < 6 ; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(num);
        }

        LinkedList list = new LinkedList(set);
        Collections.sort(list);
        System.out.println("list = " + list);

    }

}
