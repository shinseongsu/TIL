package chapter03;

import java.util.ArrayList;

public class Main {
    public static boolean solution(String s1, String s2) {
        boolean[] visited = new boolean[s1.length()];
        char[] out = new char[s1.length()];
        ArrayList<String> list = new ArrayList<>();
        permutation(s1.toCharArray(), 0 , s1.length(), s1.length(), visited, out, list);

        for (String s : list) {
            if (s2.contains(s)) {
                return true;
            }
        }

        return false;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if(depth == r) {
            list.add(new String(out));
        }

        for(int i = 0 ; i < n ; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "adbak";
        System.out.println(solution(s1, s2));
        System.out.println();

        s1 = "ac";
        s2 = "car";
        System.out.println(solution(s1, s2));
        System.out.println();

        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution(s1, s2));


    }


}
