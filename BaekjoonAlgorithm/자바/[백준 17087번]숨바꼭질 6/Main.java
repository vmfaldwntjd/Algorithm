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
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int result = 0;
        String[] a = br.readLine().split(" ");

        if (n == 1) {
            bw.write(Math.abs(Integer.parseInt(a[0]) - s) + "\n");
        } else {
            for (String e : a) {
                result = gcd(Math.abs(Integer.parseInt(e) - s), result);
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
