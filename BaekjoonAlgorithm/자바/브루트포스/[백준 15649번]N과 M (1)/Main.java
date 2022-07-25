import java.io.*;
import java.util.*;

public class Main {

    public static void print(int idx, int[] arr, boolean[] check, int n, int m) throws IOException {
        if (idx >= m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (check[i] == true)
                continue;
            check[i] = true;
            arr[idx] = i;
            print(idx + 1, arr, check, n, m);
            check[i] = false;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[9];
        int[] arr = new int[9];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        print(0, arr, check, n, m);
    }
}
