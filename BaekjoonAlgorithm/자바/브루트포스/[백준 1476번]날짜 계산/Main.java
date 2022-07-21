import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int year = 1;
        int i = 1, j = 1, k = 1, realYear = 1;

        while (true) {
            if (i == e && j == s && k == m) {
                bw.write(realYear + "\n");
                bw.flush();
                System.exit(0);
            }
            ++realYear;
            if (++i % 16 == 0)
                i = 1;
            if (++j % 29 == 0)
                j = 1;
            if (++k % 20 == 0)
                k = 1;
        }
    }
}
