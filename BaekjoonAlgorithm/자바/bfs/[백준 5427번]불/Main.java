import java.io.*;
import java.util.*;

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

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static void initDist(int[][] dist, int r, int c) {
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                dist[i][j] = -1;
            }
        }
    }

    static void initFireDist(int[][] fireDist, int r, int c) {
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                fireDist[i][j] = -1;
            }
        }
    }

    static void bfsFire(int[][] fireDist, Queue<Pair> fireQueue, int r, int c) {
        while (!fireQueue.isEmpty()) {
            Pair cur = fireQueue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                if (fireDist[nx][ny] == -2 || fireDist[nx][ny] >= 0) {
                    continue;
                }

                fireQueue.offer(new Pair(nx, ny));
                fireDist[nx][ny] = fireDist[x][y] + 1;
            }
        }
    }

    static String bfs(int[][] dist, int[][] fireDist, Queue<Pair> queue, int r, int c) {
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {// 범위 벗어나면 탈출
                    sb.append(dist[x][y] + 1);
                    return sb.toString();
                }

                if (dist[nx][ny] == -2 || dist[nx][ny] >= 0) {
                    continue;
                }

                if (fireDist[nx][ny] >= 0 && dist[x][y] + 1 >= fireDist[nx][ny]) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int n = 0; n < t; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int[][] dist = new int[r][c];
            int[][] fireDist = new int[r][c];
            Queue<Pair> fireQueue = new LinkedList<>();
            Queue<Pair> queue = new LinkedList<>();

            initFireDist(fireDist, r, c);
            initDist(dist, r, c);
            for (int i = 0; i < r; ++i) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < c; ++j) {
                    if (input[j].equals("#")) {
                        fireDist[i][j] = -2;
                        dist[i][j] = -2;
                    } else if (input[j].equals("*")) {
                        ++fireDist[i][j];
                        fireQueue.offer(new Pair(i, j));
                    } else if (input[j].equals("@")) {
                        ++dist[i][j];
                        queue.offer(new Pair(i, j));
                    }
                }
            }
            bfsFire(fireDist, fireQueue, r, c);
            sb.append(bfs(dist, fireDist, queue, r, c) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}