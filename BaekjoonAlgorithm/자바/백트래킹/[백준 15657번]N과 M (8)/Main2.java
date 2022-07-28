import java.util.*;
import java.io.*;

public class Main2 {

    public static StringBuilder print(int[] cnt, int[] input, int idx, int selected, int n, int m) {
        if (selected >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                for (int j = 1; j <= cnt[i]; ++j) {
                    sb.append(input[i] + " ");
                }
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder result = new StringBuilder();
        if (idx >= n)
            return result;
        for (int i = m - selected; i >= 1; --i) {
            cnt[idx] = i;
            result.append(print(cnt, input, idx + 1, selected + i, n, m));
        }
        cnt[idx] = 0;
        result.append(print(cnt, input, idx + 1, selected, n, m));
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[9];
        int[] input = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n);
        bw.write(print(arr, input, 0, 0, n, m) + "\n");
        bw.flush();
    }
}
