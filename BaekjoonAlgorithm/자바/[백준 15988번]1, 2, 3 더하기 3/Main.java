import java.io.*;
import java.util.*;

public class Main {

    public static long mod = 1000000009L;
    public static int max = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] d = new long[max + 1];
        int t = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= max; ++i) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            d[i] %= mod;
        }
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] + "\n");
        }
        bw.flush();
    }
}
