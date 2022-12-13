import java.io.*;

public class Main {

    public static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[MAX];
        check[0] = check[1] = true;

        for (int i = 2; i * i < MAX; ++i) {
            if (check[i] == false) {
                for (int j = i + i; j < MAX; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int j = 0; j < n / 2 + 1; ++j) {
                if (check[j] == false) {
                    if (check[n - j] == false)
                        ans++;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
