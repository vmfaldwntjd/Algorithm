import java.io.*;
import java.util.*;

public class Main {

    public static int max = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][3];
        int[][] price = new int[n + 1][3];
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans = max;
        for (int k = 0; k < 3; ++k) {
            for (int j = 0; j < 3; ++j) {
                if (j == k) {
                    d[1][j] = price[1][j];
                } else {
                    d[1][j] = max;
                }
            }
            for (int i = 2; i <= n; ++i) {
                d[i][0] = Math.min(d[i - 1][1] + price[i][0], d[i - 1][2] + price[i][0]);
                d[i][1] = Math.min(d[i - 1][0] + price[i][1], d[i - 1][2] + price[i][1]);
                d[i][2] = Math.min(d[i - 1][0] + price[i][2], d[i - 1][1] + price[i][2]);
            }
            for (int j = 0; j < 3; ++j) {
                if (j != k) {
                    ans = Math.min(ans, d[n][j]);
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
