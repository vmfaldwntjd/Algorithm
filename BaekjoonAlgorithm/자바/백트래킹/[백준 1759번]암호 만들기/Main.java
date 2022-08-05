import java.io.*;
import java.util.*;

public class Main {

    static int[] arr = new int[16];
    public static boolean isValid(StringBuilder sb) {
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
        if (vowel >= 1 && consonant >= 2)
            return true;
        else
            return false;
    }
    public static StringBuilder print(String[] input, int idx, int start, int n, int m) {
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i)
                sb.append(input[arr[i]]);
            if (isValid(sb)) {
                sb.append("\n");
                return sb;
            } else {
                sb.delete(0, m + 1);
                return sb;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < n; ++i) {
            arr[idx] = i;
            result.append(print(input, idx + 1, i + 1, n, m));
            arr[idx] = 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        Arrays.sort(input);
        bw.write(print(input, 0, 0, c, l) + "\n");
        bw.flush();
    }
}
