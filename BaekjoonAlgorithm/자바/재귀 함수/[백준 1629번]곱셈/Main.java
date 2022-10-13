import java.util.*;
import java.io.*;

public class Main {

    static long pow(long a, long b, long c) {
        if (b == 1)
            return a % c;// a가 c보다 클 수도 있으므로 c로 나눈 나머지를 반환해준다.
        long value = pow(a, b / 2, c);// 재귀 호출 b를 계속 나누다보면 b자리에는 1이 올 것이다.
        value = value * value % c; //한번 제곱하고 c로 나눈 나머지를 구함
        if (b % 2 == 0)// b가 짝수일 때는 그냥 value를 반환
            return value;
        return value * a % c;//b가 홀수일 때는 a를 한번 더 곱해줌
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        bw.write(pow(a, b, c) + "\n");
        bw.flush();
    }
}