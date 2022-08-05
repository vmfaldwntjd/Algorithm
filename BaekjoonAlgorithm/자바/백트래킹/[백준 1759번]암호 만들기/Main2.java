import java.io.*;
import java.util.*;

public class Main2 {

    static int[] arr = new int[16];

    public static boolean check(StringBuilder sb) {
        int consonant = 0;
        int vowel = 0;
        for (char c : sb.toString().toCharArray()) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++vowel;
                    break;
                default:
                    ++consonant;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
    public static StringBuilder print(String[] input, int m, String password, int idx) {
        if (password.length() >= m) {
            StringBuilder sb = new StringBuilder();
            sb.append(password);
            if (check(sb)) {
                sb.append("\n");
                return sb;
            } else {
                sb.delete(0, password.length());
                return sb;
            }
        }
        StringBuilder result = new StringBuilder();
        if (idx >= input.length)
            return result;
        result.append(print(input, m, password + input[idx], idx + 1));
        result.append(print(input, m, password, idx + 1));
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        Arrays.sort(input);
        bw.write(print(input, l, "", 0) + "\n");
        bw.flush();
    }
}