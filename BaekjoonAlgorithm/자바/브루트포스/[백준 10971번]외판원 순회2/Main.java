import java.io.*;
import java.util.*;

public class Main {

    public static int max = Integer.MAX_VALUE;

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean next_permutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i])
            --i;
        if (i <= 0)
            return false;
        int j = n - 1;
        while(arr[j] <= arr[i - 1])
            --j;
        swap(arr, i - 1, j);
        j = n - 1;
        while (i < j)
            swap(arr, i++, j--);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] w = new int[n][n];
        for (int i = 0; i < n; ++i) {
            w[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] d = new int[n];
        for (int i = 0; i < n; ++i)
            d[i] = i;
        int result = max;
        do {
            if (d[0] != 0)
                break;
            boolean flag = true;
            int sum = 0;
            for (int i = 0; i < n - 1; ++i) {
                if (w[d[i]][d[i + 1]] == 0) {
                    flag = false;
                    break;
                } else {
                    sum += w[d[i]][d[i + 1]];
                }
            }
            if (flag && w[d[n - 1]][d[0]] != 0) {
                sum += w[d[n - 1]][d[0]];
                if (result > sum)
                    result = sum;
            }
        } while (next_permutation(d, n));
        bw.write(result + "\n");
        bw.flush();
    }
}
