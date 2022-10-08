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
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        String[] graph = new String[r];
        int[][] distJ = new int[r][c];
        int[][] distF = new int[r][c];
        Queue<Pair> qJ = new LinkedList<>();
        Queue<Pair> qF = new LinkedList<>();
        for (int i = 0; i < r; ++i) {
            Arrays.fill(distJ[i], -1);
            Arrays.fill(distF[i], -1);
        }
        for (int i = 0; i < r; ++i)
            graph[i] = br.readLine();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (graph[i].charAt(j) == 'F') {
                    qF.offer(new Pair(i, j));
                    distF[i][j] = 0;
                } else if (graph[i].charAt(j) == 'J') {
                    qJ.offer(new Pair(i, j));
                    distJ[i][j] = 0;
                }
            }
        }

        //먼저 불에 대한 bfs를 진행
        while (!qF.isEmpty()) {
            Pair cur = qF.poll();
            int x = cur.getX();
            int y = cur.getY();
            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (!(nx < 0 || nx >= r || ny < 0 || ny >= c) && !(distF[nx][ny] >= 0 || graph[nx].charAt(ny) == '#')) {
                    distF[nx][ny] = distF[x][y] + 1;
                    qF.offer(new Pair(nx, ny));
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
                    bw.write(distJ[x][y] + 1 + "\n");
                    bw.flush();
                    System.exit(0);
                }
                if (!(distJ[nx][ny] >= 0 || graph[nx].charAt(ny) == '#')) {
                    if (!(distF[nx][ny] != -1 && distF[nx][ny] <= distJ[x][y] + 1)) {//불의 전파 시간에 대한 조건 추가: 불이 먼저 지나간 자리는 지훈이가 못 간다.
                        distJ[nx][ny] = distJ[x][y] + 1;
                        qJ.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        //지훈이에 대한 bfs를 마쳐도 안 끝났다는 것은 탈출 불가능함을 의미
        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }
}