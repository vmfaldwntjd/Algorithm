import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 1;

        while (n > 1) {
            result *= n;
            n--;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
