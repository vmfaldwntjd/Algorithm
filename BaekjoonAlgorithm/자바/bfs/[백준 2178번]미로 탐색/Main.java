import java.util.*;
import java.io.*;

// 좌표 지정용 class
class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

public class Main {

    static int n, m;
    public static int[] dx = new int[]{-1, 0, 1, 0}; //상 좌 하 우
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void bfs(int[][] graph, int x, int y) {
        //좌표의 정보를 담은 Pair를 생성
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; ++dir) {
                int nx = cur.getX() + dx[dir];
                int ny = cur.getY() + dy[dir];
                if (!(nx < 0 || nx >= n || ny < 0 || ny >= m) && (!(nx == 0 && ny == 0) && graph[nx][ny] == 1)) {
                    q.offer(new Pair(nx, ny));
                    graph[nx][ny] += graph[cur.getX()][cur.getY()];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        /**
         * 1. StringTokenizer로 n, m을 입력 -> n이 행, m이 열
         * 2. n개의 줄 동안 번호를 입력을 받는다. -> 이 때 붙어서 입력을 받으므로 문자열로 입력 받기
         * 3. 입력 받은 문자열을 정수형 배열로 바꿔주기 -> 2차원 정수 배열
         * 4. bfs 적용 -> 넓이의 최솟값을 구해야 한다. -> 해당 지점에 몇걸음 왔는지 정보를 저장해서 최종적으로 (n - 1, m - 1)의 값을 구하면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m]; //보드 만들기
        //문자열로 입력받기
        for (int i = 0; i < n; ++i) {
            String input = br.readLine();
            //문자열을 정수형 배열로
            for (int j = 0; j < m; ++j) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }
        //bfs 적용 -> 시작점을 입력으로 받는다.
        bfs(graph, 0, 0);

        //출력
        bw.write(graph[n - 1][m - 1] + "\n");
        bw.flush();
    }
}