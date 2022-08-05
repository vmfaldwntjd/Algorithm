import java.io.*;
import java.util.*;

public class Main {

    public static int print(int sum, int goal) {
        if (sum > goal)
            return 0;
        if (sum == goal)
            return 1;
        int now = 0;
        for (int i = 1; i <= 3; ++i)
            now += print(sum + i, goal);
        return now;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            int c = Integer.parseInt(br.readLine());
            bw.write(print(0, c) + "\n");
        }
        bw.flush();
    }
}
