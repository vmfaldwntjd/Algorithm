import java.io.*;

public class Main {

    static boolean flag = false;
    static int solution(String n) {
        if (n.length() == 1) { //문자열의 길이가 1이라면
            int num = Integer.parseInt(n);
            if (num > 0 && num % 3 == 0)// 3의 배수인지 확인
                flag = true;
            return 0;
        }
        int tmp = 0;
        // n이 문자열이므로 문자열 자리수를 하나하나 더해주어야 한다.
        for (int i = 0; i < n.length(); ++i) {
            tmp += n.charAt(i) - '0';
        }
        return solution(Integer.toString(tmp)) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();// 백만 자리의 수 이하이므로 long 범위도 넘어가기에 문자열로 입력을 받아야 한다.
        bw.write(solution(n) + "\n");
        if (flag)
            bw.write("YES\n");
        else
            bw.write("NO\n");
        bw.flush();
    }
}