package programmers.course1.problem09;

import java.util.LinkedList;
import java.util.Queue;

// 시간 복잡도: O(n)
public class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> waitList = new LinkedList<>();
        for (int truckWeight : truckWeights) {
            waitList.offer(truckWeight);
        }
        Queue<Integer> entryTimes = new LinkedList<>();
        Queue<Integer> trucksOnBridge = new LinkedList<>();
        int time = 0, totalWeight = 0;
        while (!waitList.isEmpty() || !entryTimes.isEmpty()) {
            time++;
            if (!entryTimes.isEmpty() && entryTimes.peek() + bridgeLength == time) {
                entryTimes.poll();
                totalWeight -= trucksOnBridge.poll();
            }
            if (!waitList.isEmpty() && waitList.peek() + totalWeight <= weight) {
                int currentTruck = waitList.poll();
                entryTimes.add(time);
                trucksOnBridge.offer(currentTruck);
                totalWeight += currentTruck;
            }
        }
        return time;
    }
}
