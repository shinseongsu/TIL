package practice03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void solution(int[] arr, int k, int x) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // 해시 맵에 차이 값을 키로, 해당 숫자들은 값으로 리스트 형태로 뒤로 이어줌
        // 이 때, 작은 숫자들이 앞쪽에 오도록 정렬하여 추가
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(x - arr[i]);

            ArrayList<Integer> cur = map.get(diff);
            if (cur == null) {
                map.put(diff, new ArrayList<>(Arrays.asList(arr[i])));
            } else {
                int idx = cur.size();
                for (int j = 0; j < cur.size(); j++) {
                    if (cur.get(j) > arr[i]) {
                        idx = j;
                        break;
                    }
                }
                cur.add(idx, arr[i]);
            }
        }

        // 해시 맵에서 작은 diff 순으로 꺼내서 k 개 만큼 결과 쌓일 때 까지 반복
        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        while (map.size() > 0) {
            // 최소 값 구하기 예시
            int minDiff = map.keySet().stream().min((a, b) -> a - b).get();
            ArrayList<Integer> cur = map.get(minDiff);
            map.remove(minDiff);    // 꺼낸 후에는 map 에서 삭제
            

            while (cur.size() > 0) {    // k 개 만큼 출력하기 전에 데이터가 소진될 수도 있음
                result.add(cur.get(0));
                cur.remove(0);  // 꺼낸 숫자는 리스트에서 삭제
                cnt++;

                if (cnt == k) {
                    break;
                }
            }

            if (cnt == k) {
                break;
            }
        }

        Collections.sort(result);   // 정렬 예시
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}
