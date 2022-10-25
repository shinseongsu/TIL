package programmers.course3.problem04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 자료구조/알고리즘: DFS
// 시간 복잡도: O(nm + mlogm)
// 공간 복잡도: O(n + m)
public class Solution {
    private String[][] tickets;
    private boolean[] visited;
    private List<String> possibleRoutes;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length]; // O(n) 공간, n = tickets.length
        this.possibleRoutes = new ArrayList<>(); // O(m) 공간, m = possibleRoutes.length

        addRoute("ICN", "ICN", 0); // O(n * m) 시간
        Collections.sort(possibleRoutes); // O(mlogm) 시간
        String bestRoute = possibleRoutes.get(0);

        return bestRoute.split(" ");
    }

    private void addRoute(String route, String departure, int currentLength) {
        // System.out.println("route = " + route); // 주석 해제 하시면 route가 추가되는 과정을 보실 수 있어요
        if (currentLength == tickets.length) {
            possibleRoutes.add(route);
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(departure)) {
                    String arrival = tickets[i][1];
                    visited[i] = true;
                    addRoute(route + " " + arrival, arrival, currentLength + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
