import java.io.*;
import java.util.*;

public class Main {

    public static int MAX = 100001;
    static final long MOD = 1000000009L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[][] d = new long[MAX][4];

        for (int i = 1; i <= MAX - 1; ++i) {
            if (i > 1)
                d[i][1] = (d[i - 1][2] + d[i - 1][3]) % MOD;
            else if (i == 1) {
                d[i][1] = 1;
            } else {
                d[i][1]= 0;
            }
            if (i > 2) {
                d[i][2] = (d[i - 2][1] + d[i - 2][3]) % MOD;
            } else if (i == 2) {
                d[i][2] = 1;
            } else {
                d[i][2] = 0;
            }
            if (i > 3) {
                d[i][3] = (d[i - 3][1] + d[i - 3][2]) % MOD;
            } else if (i == 3) {
                d[i][3] = 1;
            } else {
                d[i][3] = 0;
            }
        }

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(br.readLine());
            bw.write((d[n][1] + d[n][2] + d[n][3]) % MOD + "\n");
        }
        bw.flush();
    }
}
