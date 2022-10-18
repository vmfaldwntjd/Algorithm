import java.io.*;

public class Main {

    static int result = 0;
    static boolean[] isSameVert = new boolean[40];// 세로 축
    static boolean[] isSameDiag1 = new boolean[40];// 좌측 하단과 우측 상단 잇는 대각선
    static boolean[] isSameDiag2 = new boolean[40];// 좌측 상단과 우측 하단 잇는 대각선

    static void solution(int idx, int n) {
        if (idx >= n) { // 개수 세어주기
            ++result;
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (isSameVert[i] == false && isSameDiag1[idx + i] == false && isSameDiag2[idx - i + n - 1] == false) {
                isSameVert[i] = true;
                isSameDiag1[idx + i] = true;
                isSameDiag2[idx - i + n - 1] = true;
                solution(idx + 1, n);
                isSameVert[i] = false;
                isSameDiag1[idx + i] = false;
                isSameDiag2[idx - i + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        solution(0, n);
        bw.write(result + "\n");
        bw.flush();
    }
}