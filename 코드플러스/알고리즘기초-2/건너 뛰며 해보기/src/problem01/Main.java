package problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        while (t-- > 0) {
            String[] line = bf.readLine().split(" ");
            int m = Integer.valueOf(line[0]);
            int n = Integer.valueOf(line[1]);
            int x = Integer.valueOf(line[2])-1;
            int y = Integer.valueOf(line[3])-1;
            boolean ok = false;
            for (int k=x; k<(n*m); k+=m) {
                if (k%n == y) {
                    System.out.println(k+1);
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println(-1);
            }
        }
    }
}
