import java.util.*;
import java.io.*;

public class Main {

    static int youngsik(int[] arr, int n) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result += (arr[i] / 30) * 10 + 10;
        }
        return result;
    }

    static int minsik(int[] arr, int n) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result += (arr[i] / 60) * 15 + 15;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int y = youngsik(arr, n);
        int m = minsik(arr, n);
        if (y > m) {
            bw.write("M " + m + "\n");
        } else if (y < m) {
            bw.write("Y " + y + "\n");
        } else {
            bw.write("Y " + "M " + y + "\n");
        }
        bw.flush();
    }
}