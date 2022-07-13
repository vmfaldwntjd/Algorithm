import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] d = new int[10001];
        int[] p = new int[10001];

        for (int i = 1; i <= n; ++i) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                d[i] = Integer.max(d[i - j] + p[j], d[i]);
            }
        }
        bw.write(d[n] + "\n");
        bw.flush();
    }
}
