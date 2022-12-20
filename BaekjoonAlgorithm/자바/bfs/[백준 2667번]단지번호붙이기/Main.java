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

    static int[][] graph = new int[26][26];
    static boolean[][] visited = new boolean[26][26];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;

    static int bfs(int r, int c) {
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c));
        visited[r][c] = true;
        ++result;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
                ++result;
            }
        }
        return result;
    }

    static StringBuilder getResult() {
        StringBuilder sb = new StringBuilder();
        int numberOfApartmentComplex = 0;
        List<Integer> houses = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    houses.add(bfs(i, j));
                    ++numberOfApartmentComplex;
                }
            }
        }

        Collections.sort(houses);
        sb.append(numberOfApartmentComplex + "\n");
        for (int house : houses) {
            sb.append(house + "\n");
        }

        return sb;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; ++j) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        bw.write(getResult().toString() + "\n");
        bw.flush();
    }
}