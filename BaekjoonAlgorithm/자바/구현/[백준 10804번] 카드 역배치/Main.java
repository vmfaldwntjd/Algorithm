import java.io.*;
import java.util.*;

public class Main {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int a, int b) {
        int size = b - a + 1;
        for (int i = a; i < a + size / 2; ++i) {
            swap(arr, i, b - i + a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[20];
        for (int i = 0; i < 20; ++i) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < 10; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverse(arr, a - 1, b - 1);
        }
        for (int i = 0; i < 20; ++i) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}