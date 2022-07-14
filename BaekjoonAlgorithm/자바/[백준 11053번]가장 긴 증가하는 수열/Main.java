import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[n];
        Arrays.fill(d, 1);
        int temp;

        for (int i = 0; i < n; ++i) {
            temp = d[i];
            for (int j = i - 1; j >= 0; --j) {
                if (arr[i] > arr[j]) {
                    int temp2 = d[i] + d[j];
                    if (temp < temp2)
                        temp = temp2;
                }
            }
            d[i] = temp;
        }
        bw.write(Arrays.stream(d).max().getAsInt() + "");
        bw.flush();
    }
}
