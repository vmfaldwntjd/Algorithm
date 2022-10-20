import java.util.*;
import java.io.*;

class Pair {

    private final int x;
    private final int y;

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

    static int result = 70;
    static int[][] graph = new int[9][9];
    static int[][] graph_tmp = new int[9][9];
    static int[] dx = new int[]{1, 0, -1, 0};//오, 아, 왼, 위
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayList<Pair> cctv = new ArrayList<>();


    static void scan(int x, int y, int n, int m, int dir) {
        //cctv의 지점을 기준으로 특정 방향으로 graph를 계속 스캔하기
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if ((nx < 0 || nx >= n || ny < 0 || ny >= m) || graph_tmp[nx][ny] == 6)
                return;
            if (graph_tmp[nx][ny] >= 1 && graph_tmp[nx][ny] <= 5) {// cctv구역이면 그냥 넘어가기
                x = nx;
                y = ny;
                continue;
            }
            graph_tmp[nx][ny] = -1;//스캔 했다는 의미로 -1처리
            x = nx;
            y = ny;
        }
    }

    static int blind(int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (graph_tmp[i][j] == 0)
                    ++cnt;
        return cnt;
    }

    static void init(int n, int m) {
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                graph_tmp[i][j] = graph[i][j];
    }

    static void solution(int idx, int[] direction, int n, int m) {
        if (idx >= cctv.size()) {
            //direction 방향이 꽉 찬 상태 -> 특정 각 방향들의 경우가 나온 상태
            //이제 이걸 그래프에 적용하기
            for (int j = 0; j < direction.length; ++j) { //cctv 개수마다 하나를 꺼내기
                int x = cctv.get(j).getX();
                int y = cctv.get(j).getY(); //cctv 특정 좌표값 구하기
                //특정 방향에 대하여 스캔하기
                if (graph[x][y] == 1) {
                    scan(x, y, n, m, direction[j]);
                } else if (graph[x][y] == 2) {
                    scan(x, y, n, m, direction[j]);
                    scan(x, y, n, m, (direction[j] + 2) % 4);
                } else if (graph[x][y] == 3) {
                    scan(x, y, n, m, direction[j]);
                    scan(x, y, n, m, (direction[j] + 1) % 4);
                } else if (graph[x][y] == 4) {
                    scan(x, y, n, m, direction[j]);
                    scan(x, y, n, m, (direction[j] + 1) % 4);
                    scan(x, y, n, m, (direction[j] + 2) % 4);
                } else if (graph[x][y] == 5) {
                    scan(x, y, n, m, direction[j]);
                    scan(x, y, n, m, (direction[j] + 1) % 4);
                    scan(x, y, n, m, (direction[j] + 2) % 4);
                    scan(x, y, n, m, (direction[j] + 3) % 4);
                }
            }

            //cctv의 영역이 정의 되었으므로 result와 값 비교하고 다시 graph_tmp 초기화
            int cnt = blind(n, m);
            if (result > cnt)
                result = cnt;
            init(n, m);
            return;
        }

        for (int dir = 0; dir < 4; ++dir) {
            direction[idx] = dir;
            solution(idx + 1, direction, n, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //graph, graph_tmp 좌표 입력 받고 cctv 좌표 위치도 같이 입력 받기
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                graph_tmp[i][j] = graph[i][j];
                if (graph[i][j] != 6 && graph[i][j] != 0)
                    cctv.add(new Pair(i, j));
            }
        }
        int[] direction = new int[cctv.size()]; //cctv가 바라보는 특정 방향의 정보를 담는다.
        solution(0, direction, n, m);
        bw.write(result + "\n");
        bw.flush();
    }
}