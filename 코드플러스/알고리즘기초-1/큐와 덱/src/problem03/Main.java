package problem03;

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for(int k = 0 ; k < n ; k++) {
            String line = br.readLine();
            String[] s = line.split(" ");
            String cmd = s[0];

            if(cmd.equals("push_front")) {
                int num = Integer.parseInt(s[1]);
                queue.offerFirst(num);
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(s[1]);
                queue.offerLast(num);
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(queue.peekFirst()));
                }
            } else if (cmd.equals("size")) {
                bw.write(String.valueOf(queue.size()));
                bw.write("\n");
            } else if (cmd.equals("empty")) {
                if(queue.isEmpty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            } else if (cmd.equals("pop_front")) {
                if(queue.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(queue.pollFirst()));
                }
            } else if (cmd.equals("pop_back")) {
                if(queue.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(queue.pollLast()));
                }
            } else if (cmd.equals("back")) {
                if(queue.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(queue.peekLast()));
                }
                bw.write("\n");
            }
        }
        bw.flush();
    }

}
