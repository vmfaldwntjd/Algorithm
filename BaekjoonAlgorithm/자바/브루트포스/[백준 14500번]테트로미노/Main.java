import java.io.*;
import java.util.*;

public class Main {

    public static int[][] rotate90(int[][] board, int n, int m) {
        int[][] result = new int[m][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                result[j][n - 1 - i] = board[i][j];
            }
        }
        return result;
    }

    public static int[][] rotate180(int[][] board, int n, int m) {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                result[n - 1 - i][m - 1 - j] = board[i][j];
            }
        }
        return result;
    }
    public static int[][] rotate270(int[][] board, int n, int m) {
        int[][] result = new int[m][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                result[m - 1 - j][i] = board[i][j];
            }
        }
        return result;
    }

    public static int getMax(int[][] board_tmp, int n, int m) {
        int tmp;
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                //가로로 가장 긴 사각형 스캔
                if (j + 3 <= m - 1) {
                    tmp = board_tmp[i][j] + board_tmp[i][j + 1] + board_tmp[i][j + 2] + board_tmp[i][j + 3];
                    if (tmp > result) {
                        result = tmp;
                    }
                }
                //큰 정사각형 스캔하기
                if (i + 1 <= n - 1 && j + 1 <= m - 1) {
                    tmp = board_tmp[i][j] + board_tmp[i][j + 1] + board_tmp[i + 1][j] + board_tmp[i + 1][j + 1];
                    if (tmp > result) {
                        result = tmp;
                    }
                }
                //긴 ㄴ자 스캔하기
                if (i + 2 <= n - 1 && j + 1 <= m - 1) {
                    tmp = board_tmp[i][j] + board_tmp[i + 1][j] + board_tmp[i + 2][j] + board_tmp[i + 2][j + 1];
                    if (tmp > result) {
                        result = tmp;
                    }
                }
                //긴 ㄴ자 뒤집기
                if (i + 2 <= n - 1 && j + 1 <= m - 1) {
                    tmp = board_tmp[i][j + 1] + board_tmp[i + 1][j + 1] + board_tmp[i + 2][j + 1] + board_tmp[i + 2][j];
                    if (tmp > result) {
                        result = tmp;
                    }
                }

                //지그재그
                if (i + 2 <= n - 1 && j + 1 <= m - 1) {
                    tmp = board_tmp[i][j] + board_tmp[i + 1][j] + board_tmp[i + 1][j + 1] + board_tmp[i + 2][j + 1];
                    if (tmp > result) {
                        result = tmp;
                    }
                }
                //지그재그 뒤집기
                if (i + 2 <= n - 1 && j + 1 <= m - 1) {
                    tmp = board_tmp[i][j + 1] + board_tmp[i + 1][j + 1] + board_tmp[i + 1][j] + board_tmp[i + 2][j];
                    if (tmp > result) {
                        result = tmp;
                    }
                }

                //ㅜ모양
                if (i + 1 <= n - 1 && j + 2 <= m - 1) {
                    tmp = board_tmp[i][j] + board_tmp[i][j + 1] + board_tmp[i][j + 2] + board_tmp[i + 1][j + 1];
                    if (tmp > result) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] board_tmp;
        int result = 0;
        int value;
        for (int i = 0; i < n; ++i) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        value = getMax(board, n, m);
        if (result < value)
            result = value;
        board_tmp = rotate90(board, n, m);
        value = getMax(board_tmp, m, n);
        if (result < value)
            result = value;
        board_tmp = rotate180(board, n, m);
        value = getMax(board_tmp, n, m);
        if (result < value)
            result = value;
        board_tmp = rotate270(board, n, m);
        value = getMax(board_tmp, m, n);
        if (result < value)
            result = value;
        bw.write(result + "\n");
        bw.flush();
    }
}
