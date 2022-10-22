import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int[] num = new int[10];
        while (n > 0) {
            num[n % 10] += 1;
            n /= 10;
        }
        for (int i = 0; i < 10; ++i) {
            if (i != 6 && i != 9) {
                result = Math.max(result, num[i]);
            }
        }
        result = Math.max(result, (num[6] + num[9] + 1) / 2); //이 부분이 많이 헷갈렸다.
        bw.write(result + "\n");
        bw.flush();
    }
}