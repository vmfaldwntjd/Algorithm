import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int ans1 = 0, ans2 = 0;

        for (long i = 5; i <= n; i *= 5) {
            ans1 += n / i;
        }
        for (long i = 2; i <= n; i *= 2) {
            ans2 += n / i;
        }
        for (long i = 5; i <= m; i *= 5) {
            ans1 -= m / i;
        }
        for (long i = 2; i <= m; i *= 2) {
            ans2 -= m / i;
        }
        for (long i = 5; i <= n - m; i *= 5) {
            ans1 -= (n - m) / i;
        }
        for (long i = 2; i <= n - m; i *= 2) {
            ans2 -= (n - m) / i;
        }
        bw.write(Integer.min(ans1, ans2) + "\n");
        bw.flush();
    }
}
