import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int[][] d = new int[3][n + 1];
            int[][] score = new int[2][n + 1];

            for (int j = 0; j < 2; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; ++k) {
                    score[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            d[0][1] = score[0][1];
            d[1][1] = score[1][1];
            d[2][1] = 0;
            for (int j = 2; j <= n; ++j) {
                d[0][j] = Math.max(d[1][j - 1], d[2][j - 1]) + score[0][j];
                d[1][j] = Math.max(d[0][j - 1], d[2][j - 1]) + score[1][j];
                d[2][j] = Math.max(Math.max(d[0][j - 1], d[1][j - 1]), d[2][j - 1]);
            }
            bw.write(Math.max(d[0][n], d[1][n]) + "\n");
        }
        bw.flush();
    }
}
