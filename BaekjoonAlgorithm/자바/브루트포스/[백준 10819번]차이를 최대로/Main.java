import java.io.*;
import java.util.*;

public class Main {

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
        while (arr[i - 1] >= arr[j])
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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        Arrays.sort(arr);
        do {
            int temp = 0;
            for (int i = 0; i < n - 1; ++i)
                temp += Math.abs(arr[i] - arr[i + 1]);
            if (result < temp)
                result = temp;
        } while (next_permutation(arr, n));
        bw.write(result + "\n");
        bw.flush();
    }
}
