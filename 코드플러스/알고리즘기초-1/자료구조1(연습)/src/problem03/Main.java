package problem03;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        int[] freq = new int[1000001];
        String[] temp = bf.readLine().split(" ");

        for(int i = 0 ; i < n ; i++) {
            a[i] = Integer.parseInt(temp[i]);
            freq[a[i]] += 1;
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i = 1 ; i < n ; i++) {
            if(s.isEmpty()) {
                s.push(i);
            }
            while(!s.empty() && freq[a[s.peek()]] < freq[a[i]]) {
                ans[s.pop()] = a[i];
            }
            s.push(i);
        }

        while(!s.empty()) {
            ans[s.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < n ; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
