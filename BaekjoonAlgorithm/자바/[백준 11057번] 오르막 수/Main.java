import java.io.*;
import java.util.*;

public class Main {

    public static long mod = 10007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[n + 1][10];
        long result = 0L;

        for (int i = 0; i < 10; ++i)
            d[1][i] = 1;
        for (int i = 2; i <= n; ++i)
            for (int j = 0; j < 10; ++j) {
                for (int k = j; k < 10; ++k) {
                    d[i][j] += d[i - 1][k];
                    d[i][j] %= mod;
                }
            }
        for (int i = 0; i < 10; ++i) {
            result += d[n][i];
            result %= mod;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
