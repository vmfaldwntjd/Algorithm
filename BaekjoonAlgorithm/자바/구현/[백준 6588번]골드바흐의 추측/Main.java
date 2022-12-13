import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> prime = new ArrayList<Integer>();
        boolean[] check = new boolean[MAX + 1];
        check[0] = check[1] = true;
        for (int i = 2; i * i <= MAX; ++i) {
            if (check[i] == false) {
                for (int j = i + i; j <= MAX; j += i) {
                    check[j] = true;
                }
                prime.add(i);
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            if (n == 0) {
                break;
            }
            for (int i = 1; i < prime.size(); ++i) {
                int p = prime.get(i);
                if (check[n - p] == false) {
                    bw.write(n + " = " + p + " + " + (n - p) + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.flush();
    }
}
