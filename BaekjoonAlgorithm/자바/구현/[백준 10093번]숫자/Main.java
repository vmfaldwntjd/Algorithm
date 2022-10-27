import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());//a와 b 중 서로 크기 차이가 있을 수도 있다.
        if (a > b) {
            long temp = b;
            b = a;
            a = temp;
        }
        long cnt = b - a - 1;
        if (cnt < 0) {
            cnt = 0;
        }
        if (cnt > 99999) {
            cnt = 99999;
        }
        bw.write(cnt + "\n");
        for (long l = 0; l < cnt; ++l) {
            bw.write(a + 1 + l + " ");
        }
        bw.flush();
    }
}