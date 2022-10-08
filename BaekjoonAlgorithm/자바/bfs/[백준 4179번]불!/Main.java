import java.util.*;
import java.io.*;

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

    static int r, c;
    static int[] dx = new int[]{-1, 0, 1, 0};// 행 관련 좌표(상, 좌, 하, 우)
    static int[] dy = new int[]{0, -1, 0, 1};// 열 관련 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        String[] graph = new String[r];// 보드판 만들기
        int[][] distJ = new int[r][c];// 지혼이에 대한 거리 정보를 담을 이차원 배열
        int[][] distF = new int[r][c];// 불에 대한 거리 정보를 담을 이차원 배열
        Queue<Pair> qJ = new LinkedList<>();// 지훈이에 대한 큐
        Queue<Pair> qF = new LinkedList<>();// 불에 대한 큐
        for (int i = 0; i < r; ++i) {
            Arrays.fill(distJ[i], -1);// 각각 거리 정보는 -1로 초기화한다. 
            Arrays.fill(distF[i], -1);
        }
        for (int i = 0; i < r; ++i)
            graph[i] = br.readLine();// 그래프 정보 입력
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (graph[i].charAt(j) == 'F') {// 'F'를 입력받으면
                    qF.offer(new Pair(i, j));// 불 정보의 위치 정보를 불 전용 큐에 삽입
                    distF[i][j] = 0;// 불의 시작점을 찾았으므로 불 관련 거리 정보 특정 좌표를 0으로 바꿔준다.
                } else if (graph[i].charAt(j) == 'J') {// 'J'를 입력받으면
                    qJ.offer(new Pair(i, j));// 지훈이의 정보의 위치 정보를 지훈 전용 큐에 삽입
                    distJ[i][j] = 0;// 지훈이의 시작점이므로 0으로 바꿔준다. 
                }
            }
        }

        //먼저 불에 대한 bfs를 진행
        while (!qF.isEmpty()) {
            Pair cur = qF.poll();
            int x = cur.getX();// 현재 지점 좌표를 가져온다.
            int y = cur.getY();
            for (int dir = 0; dir < 4; ++dir) {// 동서남북 네 방향을 살펴보기
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (!(nx < 0 || nx >= r || ny < 0 || ny >= c) && !(distF[nx][ny] >= 0 || graph[nx].charAt(ny) == '#')) {
                    distF[nx][ny] = distF[x][y] + 1;// 불에 대한 거리 정보를 입력
                    qF.offer(new Pair(nx, ny));// 불 관련 큐에 위치 정보 삽입
                }
            }
        }

        //그 다음 지훈이에 대한 bfs를 시도해서 불과 시간 비교
        while (!qJ.isEmpty()) {
            Pair cur = qJ.poll();
            int x = cur.getX();
            int y = cur.getY();
            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) { //거리를 벗어난건 탈출 성공을 의미
                    bw.write(distJ[x][y] + 1 + "\n");// 지훈이의 탈출 시간을 출력하고 프로그램 종료
                    bw.flush();
                    System.exit(0);
                }
                if (!(distJ[nx][ny] >= 0 || graph[nx].charAt(ny) == '#')) {
                    if (!(distF[nx][ny] != -1 && distF[nx][ny] <= distJ[x][y] + 1)) {//불의 전파 시간에 대한 조건 추가
                        distJ[nx][ny] = distJ[x][y] + 1;// 지훈이의 거리 정보 좌표 업데이트
                        qJ.offer(new Pair(nx, ny));// 현재 좌표에 관한 정보를 지훈 관련 큐에 삽입
                    }
                }
            }
        }

        //지훈이에 대한 bfs를 마쳐도 안 끝났다는 것은 탈출 불가능함을 의미
        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }

}