import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[201];
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(br.readLine()); // -100 ~ 100
        for (int e : arr)
            num[e + 100] += 1;
        bw.write(num[v + 100] + "\n");
        bw.flush();
    }
}