package chapter02;

public class Solution {

    public int solution(int n) {
        int count = Integer.bitCount(n);

        while(true) {
            n = n + 1;

            if(Integer.bitCount(n) == count) {
                return n;
            }
        }
    }

}
