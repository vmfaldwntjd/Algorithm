import java.util.*;
import java.io.*;

public class Main {

    public static StringBuilder print(int[] arr, int[] input, boolean[] check, int idx, int n, int m) {
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
        for (int i = 0; i < n; ++i) {
            arr[idx] = input[i];
            check[input[i]] = true;
            result.append(print(arr, input, check, idx + 1, n, m));
            arr[idx] = 0;
            check[input[i]] = false;
        }
        return result;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[8];
        int[] input = new int[8];
        boolean[] check = new boolean[10001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n);
        bw.write(print(arr, input, check, 0, n, m) + "\n");
        bw.flush();
    }
}
