package practice02;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        // [1, n]의 범위로 이루어져 있는 것과 최대 2번 까지 나타날 수 있는 것을 이용
        // 각 원소의 값을 인덱스 삼아 해당 위치의 값에 부호처리를 하면
        // 같은 값이 있는지 여부를 체크할 수 있음
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                list.add(Math.abs(index + 1));
            }

            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
