package practice01;

public class Main {
    public static void solution(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            // 정렬되어 있는 배열이므로 idx 가 0일 때와, 이전 값보다 클 때만 nums 에 업데이트
            if (idx == 0 || num > nums[idx - 1]) {
                nums[idx++] = num;
            }
        }

        System.out.print("[" + idx + "] ");
        for (int i = 0; i < idx; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
