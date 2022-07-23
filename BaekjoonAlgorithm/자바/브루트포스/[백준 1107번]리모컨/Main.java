import java.io.*;
import java.util.*;

public class Main {

    public static int isBroken(int n_tmp, Integer[] broken_num) {
        int len = 0;
        if (n_tmp == 0) {
            if (Arrays.asList(broken_num).contains(n_tmp))
                return 0;
            else
                return 1;
        }
        while (n_tmp > 0) {
            if (Arrays.asList(broken_num).contains(n_tmp % 10))
                return 0;
            ++len;
            n_tmp /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int current = 100;
        Integer n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Integer[] broken_num = new Integer[m];
        int ans = Math.abs(n - current);
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; ++i) {
                broken_num[i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= 1000000; ++i) {
            Integer n_tmp = i;
            int n_tmp_len = isBroken(n_tmp, broken_num);
            if (n_tmp_len != 0) {
                int upDown = Math.abs(n - n_tmp);
                int cal = upDown + n_tmp.toString().length();
                if (ans > cal)
                    ans = cal;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
