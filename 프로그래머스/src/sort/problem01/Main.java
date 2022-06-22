package sort.problem01;

import java.util.Arrays;

public class Main {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] { -1 };

        int min = Integer.MAX_VALUE;
        for (int a : arr) if (a < min) min = a;

        int[] answer = new int[arr.length-1];
        int index = 0;
        for(int a : arr) {
            if(a == min) continue;
            answer[index++] = a;
        }
        return answer;
    }

    public int[] solution2(int[] arr) {
        if(arr.length == 1) return new int[] { -1 };

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr)
                .filter(a -> a != min)
                .toArray();
    }

}
