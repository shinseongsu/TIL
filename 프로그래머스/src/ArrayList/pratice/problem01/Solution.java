package ArrayList.pratice.problem01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    // 배열을 사용하는 방법
    public int[] solution(int[] arr) {
        // 최대값 구하기
        int max = 0;
        for (int a: arr) if (a > max) max = a;

        // 최댁값이 몇깨인지 확인하기
        int count = 0;
        for (int a: arr) if(a == max) count++;

        // 배열 만들기
        int[] answer = new int[count];
        // 배열에 인덱스 채우기
        int index = 0;
        for (int i = 0; i<arr.length; i++) {
           if (arr[i] == max) answer[index++] = i;
        }

        return answer;
    }

    // 리스트 사용하는 방법
    public int[] solution02(int[] arr) {
//        int max = 0;
//        for (int a: arr) if (a > max) max = a;
        int max = Arrays.stream(arr).max().getAsInt();

        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == max)
                .toArray();

//        List<Integer> list = new LinkedList<>();
//        for (int i=0; i <arr.length; i++) {
//            if (arr[i] == max) list.add(i);
//        }

//        int[] answer = new int[list.size()];
//        for (int i=0; i <list.size(); i++) {
//            answer[i] = list.get(i);
//        }
//        return answer;

        // return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
