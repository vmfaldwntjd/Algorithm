import java.io.*;
import java.util.*;



public class Main2 {

    static int[] input = new int[9];
    static int[] num = new int[9];
    static int[] cnt = new int[9];
    static int[] arr = new int[9];
    public static StringBuilder seq(int idx, int start, int n, int m) {
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
            if (cnt[i] > 0) {
                --cnt[i];
                arr[idx] = i;
                result.append(seq(idx + 1, i, n, m));
                arr[idx] = 0;
                ++cnt[i];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n);
        int c = 1;
        int k = 0;
        int tmp = input[0];
        for (int i = 1; i < n; ++i) {
            if (input[i] == tmp) {
                ++c;
            } else {
                num[k] = tmp;
                cnt[k++] = c;
                tmp = input[i];
                c = 1;
            }
        }
        num[k] = tmp;
        cnt[k] = c;
        n = k + 1;
        bw.write( seq(0, 0, n, m) + "\n");
        bw.flush();
    }
}
