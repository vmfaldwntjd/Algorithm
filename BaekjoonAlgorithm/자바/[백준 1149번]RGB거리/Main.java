import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][3];
        int[][] price = new int[n + 1][3];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(d[i], -1);
        }
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        d[1][0] = price[1][0];
        d[1][1] = price[1][1];
        d[1][2] = price[1][2];
        for (int i = 2; i <= n; ++i) {
            d[i][0] = Integer.min(d[i - 1][1] + price[i][0], d[i - 1][2] + price[i][0]);
            d[i][1] = Integer.min(d[i - 1][0] + price[i][1], d[i - 1][2] + price[i][1]);
            d[i][2] = Integer.min(d[i - 1][0] + price[i][2], d[i - 1][1] + price[i][2]);
        }
        bw.write(Integer.min(Integer.min(d[n][0], d[n][1]), d[n][2]) + "\n");
        bw.flush();
    }
}
