import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n + 1];
        check[0] = check[1] = true;

        for (int i = 2; i <= n; ++i) {
            if (check[i] == false) {
                if (m <= i)
                    bw.write(i + "\n");
                for (int j = i + i; j <= n; j += i) {
                    check[j] = true;
                }
            }
        }
        bw.flush();
    }
}
