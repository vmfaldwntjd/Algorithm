import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String yut = "DCBAE";
        for (int i = 0; i < 3; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 4; ++j) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    ++cnt;
                }
            }
            bw.write(yut.charAt(cnt) + "\n");
        }
        bw.flush();
    }
}