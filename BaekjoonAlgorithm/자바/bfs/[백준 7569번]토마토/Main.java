import java.io.*;
import java.util.*;

class Pair {

    private int x;
    private int y;
    private int z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
}

public class Main {

    static int[] dx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, -1, 1};
    static int n, m, h;

    static int calculateDays(int[][][] dist) {
        int result = 0;

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (dist[i][j][k] == -1) {
                        return -1;
                    }
                    result = Math.max(result, dist[i][j][k]);
                }
            }
        }
        return result;
    }

    static int getResultForBfs(int[][][] dist, Queue<Pair> queue) {

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int dir = 0; dir < 6; ++dir) {
                int nx = cur.getX() + dx[dir];
                int ny = cur.getY() + dy[dir];
                int nz = cur.getZ() + dz[dir];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) {
                    continue;
                }

                if (dist[nz][nx][ny] >= 0) {
                    continue;
                }

                dist[nz][nx][ny] = dist[cur.getZ()][cur.getX()][cur.getY()] + 1;
                queue.offer(new Pair(nx, ny, nz));
            }
        }

        return calculateDays(dist);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] graph = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; ++k) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        queue.offer(new Pair(j, k, i));
                    } else if (graph[i][j][k] == 0) {
                        dist[i][j][k] = -1;//익지 않음을 표시
                    }
                }
            }
        }

        bw.write(getResultForBfs(dist, queue) + "\n");
        bw.flush();
    }
}