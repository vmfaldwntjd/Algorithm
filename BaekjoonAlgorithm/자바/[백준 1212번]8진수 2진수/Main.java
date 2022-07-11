import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String[] oct = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String s = br.readLine();
        String result;

        for (char c : s.toCharArray()) {
            int n = Integer.parseInt(c + "");
            sb.append(oct[n]);
        }
        result = sb.toString();
        while (result.length() - 1 != idx && result.charAt(idx) == '0')
            idx++;
        bw.write(result.substring(idx));
        bw.flush();
    }
}
