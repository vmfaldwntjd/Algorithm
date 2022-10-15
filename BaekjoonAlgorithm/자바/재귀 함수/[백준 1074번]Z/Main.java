import java.io.*;
import java.util.*;

public class Main {

    static int solution(int n, int r, int c) {
        if (n <= 0) {
            return 0;
        }
        int half = 1 << n - 1;// 보드 길이의 절반
        if (r < half && c < half) //만약 r, c 둘다 half보다 작다면 half 안에 있다는 얘기이다.
            return solution(n - 1, r, c);
        if (r < half && c >= half)//만약 c만 half밖에 존재하고 r은 안에 있다면
            return half * half + solution(n - 1, r, c - half);
        if (r >= half && c < half)//만약 r만 half밖에 존재한다면
            return 2 * half * half + solution(n - 1, r - half, c);
        return 3 * half * half + solution(n - 1, r - half, c - half);//모두 half밖에 존재한다면
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(solution(n, r, c) + "\n");
        bw.flush();

    }
}