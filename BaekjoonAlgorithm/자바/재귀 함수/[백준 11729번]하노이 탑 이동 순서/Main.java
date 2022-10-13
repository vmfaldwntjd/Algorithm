import java.io.*;

public class Main {

    static StringBuilder hanoi(int a, int b, int n) throws IOException {
        if (n == 1) {
            StringBuilder sb = new StringBuilder();// 시간 초과 방지를 위해서 StringBuilder 사용
            sb.append(a + " " + b + "\n");
            return sb;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hanoi(a, 6 - a - b, n - 1));
        sb.append(hanoi(a, b, 1));
        sb.append(hanoi(6 - a - b, b, n - 1));
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append(hanoi(1, 3, n));//1번 기둥에서 3번 기둥까지 n개의 원판을 이동시킨다는 의미의 메소드
        bw.write((1 << n) - 1 + "\n");
        bw.write(sb + "\n");
        bw.flush();
    }
}