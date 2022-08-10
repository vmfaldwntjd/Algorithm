import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<String> result = new ArrayList<>();
    public static boolean isValid(char a, char b, char op) {
        if ((op == '<' && a > b) || (op == '>' && a < b))
            return false;
        return true;
    }
    public static void solution(char[] c, boolean[] check, int idx, int m, String s) {
        if (idx >= m) {
            result.add(s);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            if (check[i] == false) {
                if (idx == 0 || isValid(s.charAt(idx - 1), (char)(i + '0'), c[idx - 1])) {
                    check[i] = true;
                    solution(c, check, idx + 1, m, s + Integer.toString(i));
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        char[] c = new char[k]; //부등호 입력 자리
        boolean[] check = new boolean[10];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < k; ++i)
            c[i] = input[i].toCharArray()[0];
        solution(c, check, 0, k + 1, "");
        Collections.sort(result);
        bw.write(result.get(result.size() - 1) + "\n");
        bw.write(result.get(0) + "\n");
        bw.flush();
    }
}
