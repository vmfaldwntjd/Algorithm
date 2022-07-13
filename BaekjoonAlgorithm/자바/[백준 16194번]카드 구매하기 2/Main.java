import java.io.*;
import java.util.*;

public class Main {

    public static int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] d = new int[1001];
        int[] p = new int[1001];
        Arrays.fill(d, MAX);
        for (int i = 1; i <= n; ++i) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = 0;
        d[1] = p[1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                d[i] = Integer.min(d[i - j] + p[j], d[i]);
            }
        }
        bw.write(d[n] + "\n");
        bw.flush();
    }
}
