import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;
    public static int area = 0; //최대 넓이의 그림
    public static int[][] graph = new int[501][501]; //보드판

    public static boolean dfs(int r, int c) {
        //주어진 방향의 범위가 넘어가지는 않았는지 확인
        if (r <= -1 || r >= n || c <= -1 || c >= m) {
            return false;
        }
        //방문처리 되지 않았는지 확인
        if (graph[r][c] == 1) { //방문되지 않은 지점이라면
            graph[r][c] = 0; //방문처리
            area++;//영역 1추가
            //상하좌우 재귀적으로 호출하기(dfs)
            dfs(r - 1, c);
            dfs(r, c - 1);
            dfs(r + 1, c);
            dfs(r, c + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //보드 정보 입력
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        //보드에서 1로 이루어진 그림의 개수를 세어주기
        int count = 0; //그림의 개수
        int maxArea = 0;
        // 보드를 스캔하면서 그림의 개수를 세어주면서 count(그림의 개수) 및 maxArea(그림의 넓이) 업데이트
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dfs(i, j)) {
                    if (maxArea < area) {
                        maxArea = area;
                    }
                    area = 0;
                    count += 1;
                }
            }
        }
        //결과 출력
        bw.write(count + "\n"); //그림의 개수 출력
        bw.write(maxArea + "\n"); //그림의 최대 넓이 출력
        bw.flush();
    }
}