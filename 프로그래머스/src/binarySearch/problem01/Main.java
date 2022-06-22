package binarySearch.problem01;

import java.util.Arrays;

public class Main {

    // 효율성 실패
    public boolean solution(String[] phone_book) {

        for(String s1 : phone_book) {
            for(String s2 : phone_book) {
                if(s1.equals(s2)) continue;
                if(s1.startsWith(s2)) return false;
            }
        }

        return true;
    }

    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length ; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }

        return true;
    }

}
