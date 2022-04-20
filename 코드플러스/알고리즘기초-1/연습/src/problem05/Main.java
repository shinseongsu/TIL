package problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        while(t-- > 0) {
            int n = Integer.valueOf(br.readLine());
            long[][] a = new long[n+1][2];
            {
                String[] line = br.readLine().split(" ");
                for(int i = 1; i <= n ; i++) {
                    a[i][0] = Long.valueOf(line[i-1]);
                }
            }
            {
                String[] line = br.readLine().split(" ");
                for(int i = 1 ; i <= n ; i++) {
                    a[i][1] = Long.valueOf(line[i-1]);
                }
            }
            long[][] d = new long[n+1][3];
            for(int i = 1; i <= n ; i++) {
                d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + a[i][0];
                d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + a[i][1];
            }
            long ans = 0;
            ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(ans);
        }

    }
}
