import java.io.*;
import java.util.*;

public class Main {

    public static void print_seq(int max_idx, int[] arr, int[] v) throws IOException {
        if (max_idx == -1) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        print_seq(v[max_idx], arr, v);
        bw.write(arr[max_idx] + " ");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        Integer[] d = new Integer[n];
        int[] v = new int[n];
        Arrays.fill(d, 1);
        Arrays.fill(v, -1);
        int temp;
        for (int i = 0; i < n; ++i) {
            temp = d[i];
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j]) {
                    int temp2 = d[i] + d[j];
                    if (temp < temp2) {
                        temp = temp2;
                        v[i] = j;
                    }
                }
            }
            d[i] = temp;
        }

        int value_max = Collections.max(Arrays.asList(d));
        bw.write(value_max + "\n");
        bw.flush();

        int max_idx = Arrays.asList(d).indexOf(value_max);
        print_seq(max_idx, arr, v);
    }
}
