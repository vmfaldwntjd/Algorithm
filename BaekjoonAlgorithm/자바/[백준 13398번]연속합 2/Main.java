import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] d_left = new int[n + 2];
        int[] d_right = new int[n + 2];
        int[] arr = new int[n + 2];
        int result = -1001;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            d_left[i] = d_right[i] = arr[i];
        }
        for (int i = 2; i <= n; ++i) {
            int cal = d_left[i - 1] + arr[i];
            if (cal < arr[i]) {
                d_left[i] = arr[i];
            } else {
                d_left[i] = cal;
            }
        }
        for (int i = n - 1; i >= 1; --i) {
            int cal = d_right[i + 1] + arr[i];
            if (cal < arr[i]) {
                d_right[i] = arr[i];
            } else {
                d_right[i] = cal;
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (n == 1) {
                result = d_left[i];
            } else {
                int cal = Math.max(d_left[i - 1] + d_right[i + 1], d_left[i]);
                if (result < cal)
                    result = cal;
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
