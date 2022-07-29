import java.io.*;
import java.util.*;

public class Main2 {

    static int[] arr = new int[9];
    static int[] num = new int[9];
    static int[] cnt = new int[9];

    public static StringBuilder seq(int idx, int n, int m) {
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(num[arr[i]]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                arr[idx] = i;
                result.append(seq(idx + 1, n, m));
                cnt[i] += 1;
            }
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] input = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n);
        int k = 0;
        int x = input[0];
        int c = 1;
        for (int i = 1; i < n; ++i) {
            if (x == input[i]) {
                c += 1;
            } else {
                num[k] = x; //중복되지 않은 수열을 담을 공간
                cnt[k++] = c; //특정 자리 안의 값이 몇 번 중복되었는지 기록
                x = input[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
        n = k + 1;
        bw.write(seq(0, n, m) + "\n");
        bw.flush();
    }

}
