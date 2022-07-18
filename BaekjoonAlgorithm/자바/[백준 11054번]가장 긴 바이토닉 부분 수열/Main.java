import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] d_right = new int[n + 1];
        int[] d_left = new int[n + 1];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            d_right[i] = 1;
            d_left[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            int tmp_left = d_left[i];
            for (int j = i - 1; j >= 1; --j) {
                if (arr[i] > arr[j]) {
                    int cal = d_left[i] + d_left[j];
                    if (cal > tmp_left)
                        tmp_left = cal;
                }
            }
            d_left[i] = tmp_left;
        }
        for (int i = n - 1; i >= 1; --i) {
            int tmp_right = d_right[i];
            for (int j = i + 1; j <= n; ++j) {
                if (arr[i] > arr[j]) {
                    int cal = d_right[i] + d_right[j];
                    if (cal > tmp_right)
                        tmp_right = cal;
                }
            }
            d_right[i] = tmp_right;
        }
        for (int i = 1; i <= n; ++i) {
            int cal = d_left[i] + d_right[i];
            if (result < cal)
                result = cal;
        }
        bw.write(result - 1 + "\n");
        bw.flush();
    }
}
