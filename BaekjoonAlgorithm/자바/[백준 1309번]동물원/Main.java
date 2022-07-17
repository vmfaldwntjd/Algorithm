import java.io.*;
import java.util.*;

public class Main {

    public static int mod = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][3];

        d[1][0] = d[1][1] = d[1][2] = 1;
        for (int i = 2; i <= n; ++i) {
            d[i][0] = d[i - 1][0] + d[i - 1][1] + d[i - 1][2];
            d[i][0] %= mod;
            d[i][1] = d[i - 1][0] + d[i - 1][2];
            d[i][1] %= mod;
            d[i][2] = d[i - 1][0] + d[i - 1][1];
            d[i][2] %= mod;
        }
        bw.write((d[n][0] + d[n][1] + d[n][2]) % mod + "\n");
        bw.flush();
    }
}
