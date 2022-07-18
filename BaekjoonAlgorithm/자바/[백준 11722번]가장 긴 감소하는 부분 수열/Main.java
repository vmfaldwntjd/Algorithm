import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            int temp = d[i];
            for (int j = i - 1; j >= 1; --j) {
                if (arr[i] < arr[j]) {
                    int cal = d[i] + d[j];
                    if (temp < cal)
                        temp = cal;
                }
            }
            d[i] = temp;
        }
        bw.write(Arrays.stream(d).max().getAsInt() + "\n");
        bw.flush();
    }
}
