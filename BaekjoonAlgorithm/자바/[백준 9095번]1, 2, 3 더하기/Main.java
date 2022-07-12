import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] d = new int[12];
        int t = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 11; ++i) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] + "\n");
        }
        bw.flush();
    }
}
