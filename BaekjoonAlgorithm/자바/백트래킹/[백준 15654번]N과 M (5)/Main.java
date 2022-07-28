import java.io.*;
import java.util.*;

public class Main {

    public static void print(int[] arr, boolean[] check, int[] input, int idx, int n, int m) throws IOException{
        if (idx >= m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (check[input[i]] == false) {
                arr[idx] = input[i];
                check[input[i]] = true;
                print(arr, check, input, idx + 1, n, m);
                arr[idx] = 0;
                check[input[i]] = false;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[9];
        int[] input = new int[n];
        boolean[] check = new boolean[10001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        print(arr, check, input, 0, n, m);
        bw.flush();
    }
}
