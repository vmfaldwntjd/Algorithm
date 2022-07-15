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

        d[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            d[i] = d[i - 1] + arr[i];
            if (d[i] < arr[i]) {
                d[i] = arr[i];
            }
        }
        bw.write(Arrays.stream(d).max().getAsInt() + "\n");
        bw.flush();
    }
}
