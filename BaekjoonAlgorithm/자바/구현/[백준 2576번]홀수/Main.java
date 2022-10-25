import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            int input = Integer.parseInt(br.readLine());
            if ((input & 1) == 1) {
                odd.add(input);
            }
        }
        if (odd.size() == 0) {
            bw.write(-1 + "\n");
        } else {
            Collections.sort(odd);
            bw.write(odd.stream().mapToInt(a -> a).sum() + "\n");
            bw.write(odd.get(0) + "\n");
        }
        bw.flush();
    }
}