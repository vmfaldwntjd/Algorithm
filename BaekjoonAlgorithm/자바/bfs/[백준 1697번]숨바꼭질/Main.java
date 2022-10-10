import java.io.*;
import java.util.*;

public class Main {

    static int[] dist = new int[100001];

    static void bfs(int x, int k) {
        Queue<Integer> q = new LinkedList<>();
        dist[x] = 0;
        q.offer(x);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (x == k)
                return;
            // 여기서 거리 1, 거리 * 2의 경우의 큐를 넣어주기
            for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (!((i < 0 || i > 100000) || dist[i] > 0)) {
                    dist[i] = dist[cur] + 1;
                    if (i == k)
                        return;
                    q.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        /**
         * 수빈이 위치: N, 동생 위치: K
         * 수빈이는 걷거나 순간이동 가능(위치: x)
         * -> 걸을 때: x-1, x + 1
         * -> 순간이동: 2*X
         * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 구하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arrays.fill(dist, -1);
        int n = Integer.parseInt(st.nextToken());// 수빈이 처음 위치
        int k = Integer.parseInt(st.nextToken());// 동생의 위치
        bfs(n, k);
        bw.write(dist[k] + "\n");
        bw.flush();
    }
}