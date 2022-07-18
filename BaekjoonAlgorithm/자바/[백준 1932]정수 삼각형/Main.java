import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        int[][] tri = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=    i; ++j) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; ++i)
            d[n][i] = tri[n][i];

        for (int i = n - 1; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                d[i][j] = Math.max(d[i + 1][j] + tri[i][j], d[i + 1][j + 1] + tri[i][j]);
            }
        }
        bw.write(d[1][1] + "\n");
        bw.flush();
    }
}
