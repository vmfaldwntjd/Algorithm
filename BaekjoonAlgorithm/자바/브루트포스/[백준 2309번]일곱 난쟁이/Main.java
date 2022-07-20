import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < 9; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int total = Arrays.stream(arr).sum();
        Arrays.sort(arr);
        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 9; ++j) {
                int cal = arr[i] + arr[j];
                if (total - cal == 100) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (i != idx1 && i != idx2)
                bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}
