import java.io.*;
import java.util.*;

public class Main {

    public static void print(int[] arr, int idx, int start, int n, int m) throws IOException {
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
                print(arr,idx + 1, i, n, m);
                arr[idx] = 0;
            }
        }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[9];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        print(arr, 0, 1, n, m);
        bw.flush();
    }
}
