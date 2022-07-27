import java.io.*;
import java.util.*;

public class Main2 {

    public static StringBuilder print(int[] cnt, int num, int selected, int n, int m) {
        if (selected >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < cnt[i]; ++j)
                    sb.append(i + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder result = new StringBuilder();
        if (num > n)
            return result;
        for (int i = m - selected; i >= 1; --i) {
            cnt[num] = i;
            result.append(print(cnt, num + 1, selected + i, n, m));
        }
        cnt[num] = 0;
        result.append(print(cnt, num + 1, selected, n, m));
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[9];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bw.write(print(cnt, 1, 0, n, m) + "\n");
        bw.flush();
    }
}
