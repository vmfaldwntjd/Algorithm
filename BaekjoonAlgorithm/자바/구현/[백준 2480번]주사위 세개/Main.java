import java.util.*;
import java.io.*;

public class Main {

    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if (arr[0] == arr[2]) {
            bw.write(10000 + arr[0] * 1000 + "\n");
        } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
            bw.write(1000 + arr[1] * 100 + "\n");
        } else {
            bw.write(arr[2] * 100 + "\n");
        }
        bw.flush();
    }
}