import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a + b == c) {
            bw.write(String.format("%d+%d=%d", a, b, c) + "\n");
        } else if (a % b == 0 && a / b == c) {
            bw.write(String.format("%d/%d=%d", a, b, c) + "\n");
        } else if (a * b == c) {
            bw.write(String.format("%d*%d=%d", a, b, c) + "\n");
        } else if (a - b == c) {
            bw.write(String.format("%d-%d=%d", a, b, c) + "\n");
        } else if (b + c == a) {
            bw.write(String.format("%d=%d+%d", a, b, c) + "\n");
        } else if (b % c == 0 && b / c == a) {
            bw.write(String.format("%d=%d/%d", a, b, c) + "\n");
        } else if (b * c == a) {
            bw.write(String.format("%d=%d*%d", a, b, c) + "\n");
        } else if (b - c == a) {
            bw.write(String.format("%d=%d-%d", a, b, c) + "\n");
        }
        bw.flush();
    }
}
