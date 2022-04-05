package problem01;

import java.io.*;
import java.util.Stack;

public class Main {
    static void print(BufferedWriter bw, Stack<Character> s) throws IOException {
        while(!s.isEmpty()) {
            bw.write(s.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean tag = false;
        Stack<Character> s = new Stack<>();

        for(char ch : str.toCharArray()) {
            if (ch == '<') {
                print(bw, s);
                tag = true;
                bw.write(ch);
            } else if (ch == '>') {
                tag = false;
                bw.write(ch);
            } else {
                if (ch == ' ') {
                    print(bw, s);
                    bw.write(ch);
                } else {
                    s.push(ch);
                }
            }
        }

        print(bw, s);
        bw.write("\n");
        bw.flush();
    }

}
