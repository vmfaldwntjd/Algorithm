import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        int[][] d = new int[n + 1][2];

        for (int i = 1; i <= n; ++i) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        d[1][0] = 0;
        d[1][1] = wine[1];
        if (n >= 2) {
            d[2][0] = d[1][1];
            d[2][1] = d[1][1] + wine[2];
            for (int i = 3; i <= n; ++i) {
                d[i][1] = Math.max(wine[i - 1] + d[i - 2][0] + wine[i], d[i - 1][0] + wine[i]);
                d[i][0] = Math.max(d[i - 1][1], d[i - 1][0]);
            }
        }
        bw.write(Math.max(d[n][0], d[n][1]) + "\n");
        bw.flush();
    }
}
