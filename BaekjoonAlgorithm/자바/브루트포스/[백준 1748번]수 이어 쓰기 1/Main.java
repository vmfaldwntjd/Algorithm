import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, ++len) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            result += (long)(end - start + 1) * len;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
