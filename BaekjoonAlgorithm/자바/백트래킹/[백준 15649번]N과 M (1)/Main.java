import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder print(int idx, int[] arr, boolean[] check, int n, int m) {
        if (idx >= m) {// 수열의 개수 m이 되면
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {// 수열의 대상은 1부터 n
            if (!check[i]) {// arr배열에 있지 않다면 -> 중복 방지
                check[i] = true;
                arr[idx] = i;// arr에 정수 입력
                sb.append(print(idx + 1, arr, check, n, m));// 그리고 arr다음 위치인 idx + 1로 업데이트하면서 재귀 호출
                check[i] = false;// 다시 나오면 해당 자리는 없어진 상태이므로 false처리
            }
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[9];
        int[] arr = new int[9];
        bw.write(print(0, arr, check, n, m) + "\n");//print의 인자는 배열 arr의 위치를 나태낼 idx, n, m, 그리고 rr, check이다.
        bw.flush();
    }
}