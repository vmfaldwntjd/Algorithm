import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            bw.write("0" + "");
        } else {
            while (n != 0) {
                if (n % (-2) < 0) {
                    sb.append(-1 * n % (-2));
                    n = (n - 1) / (-2);
                } else {
                    sb.append(n % (-2));
                    n /= (-2);
                }
            }
            bw.write(sb.reverse().toString());
        }
        bw.flush();
    }
}
