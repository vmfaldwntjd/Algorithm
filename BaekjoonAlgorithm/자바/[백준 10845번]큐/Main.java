import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        int size = 0, start = 0, end = 0;

        for (int i = 0; i < n; ++i) {
            String[] s = sc.nextLine().split(" ");
            if (s[0].equals("push")) {
                arr[end++] = Integer.parseInt(s[1]);
                ++size;
            } else if (s[0].equals("pop")) {
                if (size == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(arr[start++] + "\n");
                    --size;
                }
            } else if (s[0].equals("size")) {
                bw.write(size + "\n");
            } else if (s[0].equals("empty")) {
                if (size == 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (s[0].equals("front")) {
                if (size == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(arr[start] + "\n");
                }
            } else if (s[0].equals("back")) {
                if (size == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(arr[end - 1] + "\n");
                }
            }
        }
        bw.flush();
    }
}
