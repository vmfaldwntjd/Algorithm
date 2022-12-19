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

    static int[][] graph = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n, m, k;

    static void updateGraph(int lowerLeftX, int lowerLeftY, int upperRightX, int upperRightY) {

        for (int i = m - upperRightY; i < m - lowerLeftY; ++i) {
            for (int j = lowerLeftX; j < upperRightX; ++j) {
                graph[i][j] = 1;
            }
        }

    }

    static int bfs(int i, int j) {
        int result = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        ++result;
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || graph[nx][ny] == 1) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                ++result;
                visited[nx][ny] = true;
            }
        }
        return result;
    }

    static StringBuilder getResult() {

        List<Integer> areas = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    areas.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areas);

        sb.append(areas.size() + "\n");

        for (int area : areas) {
            sb.append(area + " ");
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int lowerLeftX = Integer.parseInt(st.nextToken());
            int lowerLeftY = Integer.parseInt(st.nextToken());
            int upperRightX = Integer.parseInt(st.nextToken());
            int upperRightY = Integer.parseInt(st.nextToken());
            updateGraph(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
        }

        bw.write(getResult().toString() + "\n");
        bw.flush();
    }
}