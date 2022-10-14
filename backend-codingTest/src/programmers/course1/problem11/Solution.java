package programmers.course1.problem11;

import java.util.Stack;

// 시간 복잡도: O(n^2)
public class Solution {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<PriceEntry> priceHistory = new Stack<>();

        for (int i = 0; i < n; i++) {
            int price = prices[i];
            while (!priceHistory.isEmpty() && price < priceHistory.peek().price) {
                PriceEntry priceEntry = priceHistory.pop();
                answer[priceEntry.index] = i - priceEntry.index;
            }
            priceHistory.push(new PriceEntry(i, price));
        }

        while (!priceHistory.isEmpty()) {
            PriceEntry priceEntry = priceHistory.pop();
            answer[priceEntry.index] = n - priceEntry.index - 1;
        }

        return answer;
    }

    class PriceEntry {
        int index;
        int price;

        public PriceEntry(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

}
