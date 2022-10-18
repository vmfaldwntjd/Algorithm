import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int n, s;
    static int[] input = new int[30];
    static void solution(int cur, int tot) {
        if (cur == n) {
            if (tot == s)
                ++result;
            return;
        }
        solution(cur + 1, tot);//선택하지 않은 경우
        solution(cur + 1, tot + input[cur]);//선택한 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        solution(0, 0);
        if (s == 0)
            --result;
        bw.write(result + "\n");
        bw.flush();
    }
}