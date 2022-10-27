import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[5];

        for (int i = 0; i < 5; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        bw.write(Arrays.stream(arr).sum() / 5 + "\n");
        bw.write(arr[2] + "\n");
        bw.flush();
    }
}