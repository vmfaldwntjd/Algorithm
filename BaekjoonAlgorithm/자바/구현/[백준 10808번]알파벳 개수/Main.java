import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[] alphaNum = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            alphaNum[(int)s.toCharArray()[i] - 97] += 1;
        }
        for (int i = 0; i < alphaNum.length; ++i) {
            bw.write(alphaNum[i] + " ");
        }
        bw.flush();
    }
}