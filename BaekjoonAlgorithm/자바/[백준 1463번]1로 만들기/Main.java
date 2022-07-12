import java.io.*;

public class Main {

    public static int MAX = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[MAX];
        dp[2] = dp[3] = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 4; i <= n; ++i) {
            int result1 = MAX;
            int result2 = MAX;
            int result3;
            if (i % 2 == 0)
                result1 = dp[i / 2] + 1;
            if (i % 3 == 0)
                result2 = dp[i / 3] + 1;
            result3 = dp[i - 1] + 1;
            dp[i] = Integer.min(Integer.min(result1, result2), result3);
        }
        bw.write(dp[n] + "");
        bw.flush();
    }
}
