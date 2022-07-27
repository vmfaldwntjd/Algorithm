import java.io.*;
import java.util.*;

public class Main {

    public static void print(int[] arr, int num, int selected, int n, int m) throws IOException {
        if (selected == m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        if (num > n)
            return;
        arr[selected] = num;
        print(arr, num + 1, selected + 1, n, m);
        arr[selected] = 0;
        print(arr, num + 1, selected, n, m);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[9];
        print(arr, 1, 0, n, m);
    }
}
