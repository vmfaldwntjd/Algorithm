import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[10008];
        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        if (n > 2) {
            for (int i = 3; i <= n; ++i) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
