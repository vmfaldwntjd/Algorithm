import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int[] t = new int[17];
    static int[] p = new int[17];
    public static void revenue(int n, int day, int sum) {
        if (day == n + 1) {
            if (result < sum)
                result = sum;
            return;
        }
        if (day > n + 1)
            return;
        revenue(n, day + t[day], sum + p[day]);
        revenue(n, day + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        revenue(n, 1, 0);
        bw.write(result + "\n");
        bw.flush();
    }
}
