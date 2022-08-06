import java.io.*;
import java.util.*;

public class Main {

    public static boolean check(String password) {
        int consonant = 0;
        int vowel = 0;
        for (char c : password.toCharArray()) {
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
    public static void print(String[] input, String password, int idx, int c, int l) throws IOException {
        if (password.length() >= l) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            if (check(password))
                bw.write(password + "\n");
            bw.flush();
            return;
        }
        if (idx >= input.length)
            return;
        print(input, password + input[idx], idx + 1, c, l);
        print(input, password, idx + 1, c, l);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        Arrays.sort(input);
        print(input, "", 0, c, l);
    }
}
