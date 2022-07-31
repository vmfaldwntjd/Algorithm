import java.util.*;
import java.io.*;

public class Main2 {

    static int[] input = new int[9];
    static int[] arr = new int[9];
    static int[] num = new int[9];

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
            arr[idx] = i;
            result.append(seq(idx + 1, i, n, m));
            arr[idx] = 0;
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
        int k = 0;
        int tmp = input[0];
        for (int i = 1; i < n; ++i) {
            if (tmp != input[i]) {
                num[k++] = tmp;
                tmp = input[i];
            }
        }
        num[k++] = tmp;
        n = k;
        bw.write(seq(0, 0, n, m) + "\n");
        bw.flush();
    }
}
