import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            String[] s = br.readLine().split(" ");
            String cmd = s[0];
            if (cmd.equals("push_front")) {
                deque.addFirst(Integer.parseInt(s[1]));
            } else if (cmd.equals("push_back")) {
                deque.addLast(Integer.parseInt(s[1]));
            } else if (cmd.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.peekFirst()) + "\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(String.valueOf(deque.size()) + "\n");
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.pollFirst()) + "\n");
                }
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.pollLast()) + "\n");
                }
            } else if (cmd.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(String.valueOf(deque.peekLast()) + "\n");
                }
            }
        }
        bw.flush();
    }
}
