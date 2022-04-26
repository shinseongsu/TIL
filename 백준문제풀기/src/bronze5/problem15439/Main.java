package bronze5.problem15439;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int result = 0;
        boolean[] visited = new boolean[count];

        for(int i = 0 ; i < count ; i++) {
            visited[i] = true;
            for(int j = 0 ; j < count ; j++) {
                if(visited[j] != true) result++;
            }
            visited[i] = false;
        }

        System.out.println(result);
    }
}
