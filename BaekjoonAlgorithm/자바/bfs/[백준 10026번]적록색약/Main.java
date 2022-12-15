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

    static String[][] graph = new String[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static void bfs(int r, int c, int n, String color) {
        Queue<Pair> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Pair(r, c));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || !graph[nx][ny].equals(color)) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new Pair(nx, ny));
            }
        }
    }

    static int  getGeneralResult(int n) {
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    bfs(i, j, n, graph[i][j]);
                    ++result;
                }
            }
        }

        return result;
    }

    static void initVisited(int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                visited[i][j] = false;
            }
        }
    }

    static void bfsRedGreen(int r, int c, int n, String color) {
        Queue<Pair> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Pair(r, c));
        boolean blueFlag = false;

        if (color.equals("B")) {
            blueFlag = true;
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (!graph[nx][ny].equals(color)) {
                    if (blueFlag) {
                        continue;
                    }

                    if (!((color.equals("R") && graph[nx][ny].equals("G")) ||
                            color.equals("G") && graph[nx][ny].equals("R"))) {
                        continue;
                    }
                }
                visited[nx][ny] = true;
                queue.offer(new Pair(nx, ny));
            }
        }
    }

    static int getRedGreenBlindResult(int n) {
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    bfsRedGreen(i, j, n, graph[i][j]);
                    ++result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; ++j) {
                graph[i][j] = input[j];
            }
        }

        sb.append(getGeneralResult(n) + " ");
        initVisited(n);
        sb.append(getRedGreenBlindResult(n));

        bw.write(sb.toString());
        bw.flush();
    }
}