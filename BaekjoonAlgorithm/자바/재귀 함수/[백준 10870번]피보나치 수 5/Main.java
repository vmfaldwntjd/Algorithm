import java.io.*;

public class Main {

    static int fibo(int n) {
        if (n <= 0)
            return 0;
        if (n <= 2)
            return 1;
        return (fibo(n - 1) + fibo(n - 2));
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(fibo(n) + "\n");
        bw.flush();
    }

}