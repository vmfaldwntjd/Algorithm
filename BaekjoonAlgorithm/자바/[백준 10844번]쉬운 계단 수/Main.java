import java.io.*;

public class Main {

    public static long mod = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[n + 1][10];
        long result = 0L;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 9; ++j) {
                if (i == 1) {
                    d[i][j] = 1L % mod;
                } else {
                    if (j == 9) {
                        d[i][j] = d[i - 1][8] % mod;
                    } else if (j == 1) {
                        if (i == 2) {
                            d[i][j] = 2;
                        } else {
                            d[i][j] = (d[i - 2][1] + d[i - 1][2]) % mod;
                        }
                    } else {
                        d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
                    }
                }
            }
        }
        for (int i = 1; i <= 9; ++i) {
            result += d[n][i];
        }
        bw.write(result % mod + "\n");
        bw.flush();

    }
}
