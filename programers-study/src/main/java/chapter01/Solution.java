package chapter01;

import java.util.Arrays;

public class Solution {

    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split(""))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();

        return x % sum == 0;
    }

}
