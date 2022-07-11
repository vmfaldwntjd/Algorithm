import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();
        int count = 0, result = 0;

        for (int i = s.length - 1; i >= 0; --i) {
            if (i == 0) {
                int temp = i;
                for (int j = count; j >= 0; --j) {
                    result += Integer.parseInt(s[temp++] + "") * (int)Math.pow(2, j);
                }
                sb.append(result);
                count = 0;
                result = 0;
            } else if (count == 2) {
                int temp = i;
                for (int j = count; j >= 0; --j) {
                    result += Integer.parseInt(s[temp++] + "") * (int)Math.pow(2, j);
                }
                sb.append(result);
                count = 0;
                result = 0;
            } else {
                ++count;
            }
        }
        bw.write(sb.reverse().toString());
        bw.flush();
    }
}
