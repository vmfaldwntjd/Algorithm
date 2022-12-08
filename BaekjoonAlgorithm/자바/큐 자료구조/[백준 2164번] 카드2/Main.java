import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; ++i) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            int value = queue.poll();
            queue.addLast(value);
        }
        bw.write(queue.poll() + "\n");
        bw.flush();
    }
}