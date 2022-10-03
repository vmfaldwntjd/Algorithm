import java.util.*;
import java.io.*;

//좌표 정보 저장용 class
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

    public static int n, m;
    public static int[][] graph = new int[501][501];
    public static int area = 0;
    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, -1, 0, 1};

    public static boolean bfs(int r, int c) {
        //만약 현재 지점이 이미 방문된 곳이거나 범위를 벗어난다면
        if ((r < 0 || r >= n || c < 0 || c >= m) || graph[r][c] == 0)
            return false;
        Queue<Pair> q = new LinkedList<>(); //위치 정보를 담기 위한 큐 생성
        q.offer(new Pair(r, c)); // 현재 위치 정보를 큐에 담는다. 
        graph[r][c] = 0; // 이 지점은 방문이 완료된 곳이므로 0으로 업데이트
        ++area;
        while (!q.isEmpty()) {
            Pair cur = q.poll(); //현재 지점을 큐에서 뽑아낸다. 
            for (int dir = 0; dir < 4; ++dir) { //이 지점을 기준으로 네 방향을 돌면서 방문하지 않은 곳을 찾아내며 큐에 삽입한다. 
                int nr = cur.getX() + dr[dir]; // 행 업데이트
                int nc = cur.getY() + dc[dir]; // 열 업데이트
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) // 보드 범위 예외처리
                    continue;
                if (graph[nr][nc] == 1) { // 방문하지 않은 곳이라면
                    graph[nr][nc] = 0;
                    ++area; //영역도 1 더해준다.
                    q.offer(new Pair(nr, nc)); //방문하지 않았던 곳이므로 큐에 삽입
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = 0;
        int maxArea = 0;
        //보드판 입력하기
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        //보드판 하나하나 돌면서 bfs적용하기
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (bfs(i, j)) {
                    ++count;
                    if (maxArea < area)
                        maxArea = area;
                }
                area = 0;
            }
        }
        bw.write(count + "\n");
        bw.write(maxArea + "\n");
        bw.flush();
    }
}