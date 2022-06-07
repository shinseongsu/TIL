package set.problem02;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public boolean solution(String[] words) {
        Set<String> set = new HashSet<>();

        set.add(words[0]);
        char last = words[0].charAt(words[0].length() -1);

        for (int i=1; i< words.length; i++) {
            String w = words[i];
            char first = w.charAt(0);

            if(last != first) return false;
            if(!set.add(words[i])) return false;

            last = w.charAt(w.length()-1);
        }

        return true;
    }
}
