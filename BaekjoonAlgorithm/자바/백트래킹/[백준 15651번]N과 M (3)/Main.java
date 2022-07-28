import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder print(int idx, int[] arr, int n, int m) throws IOException {
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(arr[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            arr[idx] = i;
            result.append(print(idx + 1, arr, n, m));
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[9];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bw.write(print(0, arr, n, m) + "\n");
        bw.flush();
    }
}
