import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[14];
    static int[] num = new int[14];
    public static StringBuilder seq(int idx, int start, int n, int m) throws IOException {
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(num[arr[i]]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < n; ++i) {
            arr[idx] = i;
            result.append(seq(idx + 1, i + 1, n, m));
            arr[idx] = 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (Integer.parseInt(st.nextToken()) != 0) {
            int n = st.countTokens();
            for (int i = 0; i < n; ++i)
                num[i] = Integer.parseInt(st.nextToken());
            bw.write(seq(0, 0, n, 6) + "\n");
            st = new StringTokenizer(br.readLine());
        }
        bw.flush();
    }
}
