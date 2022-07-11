import java.io.*;
import java.util.*;

public class Main {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            String[] s = br.readLine().split(" ");
            long result = 0;
            for (int j = 1; j < s.length - 1; ++j) {
                for (int k = j + 1; k < s.length; ++k) {
                    result += gcd(Integer.parseInt(s[j]), Integer.parseInt(s[k]));
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
