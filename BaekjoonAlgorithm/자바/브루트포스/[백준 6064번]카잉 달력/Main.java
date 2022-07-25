import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine()); //M, N, x, y
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            boolean flag = false;

            for (int j = x; j < (m * n); j += m) {
                if (j % n == y) {
                    bw.write(j + 1 + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
    }
}
