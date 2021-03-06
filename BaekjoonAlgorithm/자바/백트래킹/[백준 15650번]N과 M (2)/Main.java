import java.io.*;
import java.util.*;

public class Main {

    public static void print(int idx, int start, int[] arr, int n, int m) throws IOException {
        if (idx >= m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }
        for (int i = start; i <= n; ++i) {
            arr[idx] = i;
            print(idx + 1, i + 1, arr, n, m);
            arr[idx] = 0;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[9];
        print(0, 1, arr, n, m);
    }
}
