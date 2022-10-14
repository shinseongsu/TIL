package programmers.course1.problem02;

import java.util.Set;

// 시간복잡도 : O(n * m)
public class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> phoneNumbers = Set.of(phoneBook);
        for (String phoneNumber : phoneBook) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                if (phoneNumbers.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
