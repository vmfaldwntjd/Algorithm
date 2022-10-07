import java.util.*;
import java.io.*;

class Pair {// 좌표 저장용 class
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

    public static int n, m;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];// 그래프 생성
        int[][] dist = new int[n][m];// 최소 거리를 등록할 정보 메모리 생성 처음에는 전부 0으로 초기화
        Queue<Pair> q = new LinkedList<>();// 좌표값 등록할
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());// 특정 그래프 좌표에 토마토 정보 등록
                if (graph[i][j] == 1)// 만약 해당 좌표의 토마토가 익은 토마토라면
                    q.offer(new Pair(i, j));// 큐에 좌표를 등록을 해준다.(미리 큐에 등록한다는 것에 주의)
                else if (graph[i][j] == 0)// 만약 해당 좌표의 토마토가 익지 않은 토마토라면
                    dist[i][j] = -1;// 익지 않았다는 의미로 dist의 해당 좌표에 -1을 등록한다.
            }
        }
        while (!q.isEmpty()) {//bfs 진행
            Pair cur = q.poll();// 큐에서 한 좌표를 뽑아준다.
            for (int dir = 0; dir < 4; ++dir) {// 좌표 기준 4 방향을 돌아보면서 bfs 진행
                int nx = cur.getX() + dx[dir];// 새로운 지점으로 이동
                int ny = cur.getY() + dy[dir];
                if (!(nx < 0 || nx >= n || ny < 0 || ny >= m) && !(dist[nx][ny] >= 0)) {// 그래프 범위 안이고, 익지 않은 곳이라면
                    dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;// 거리 정보 등록하기
                    q.offer(new Pair(nx, ny));// 큐에 삽입
                }
            }
        }
        int result = 0;// dist에서 최댓값을 찾아서 result에 저장할 것이다.
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dist[i][j] == -1) {
                    bw.write(-1 + "\n");
                    bw.flush();
                    System.exit(0);
                }
                result = Math.max(result, dist[i][j]);
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
