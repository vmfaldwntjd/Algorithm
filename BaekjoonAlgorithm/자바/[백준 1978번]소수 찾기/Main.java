import java.io.*;

public class Main {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (String s : input) {
            int toNum = Integer.parseInt(s);
            if (isPrime(toNum))
                ++result;
        }
        bw.write(Integer.toString(result));
        bw.flush();
    }
}
