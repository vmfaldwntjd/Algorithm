import java.io.*;
import java.util.*;

public class Main {

    public static int check(String[][] board, int n) {
        int ans = 1;

        for (int i = 0; i < n; ++i) {
            int ans_tmp = 1;
            for (int j = 0; j < n - 1; ++j) {
                if (board[i][j].equals(board[i][j + 1])) {
                    ++ans_tmp;
                } else {
                    if (ans < ans_tmp) {
                        ans = ans_tmp;
                    }
                    ans_tmp = 1;
                }
            }
            if (ans < ans_tmp) {
                ans = ans_tmp;
            }
            ans_tmp = 1;
            for (int j = 0; j < n - 1; ++j) {
                if (board[j][i].equals(board[j + 1][i])) {
                    ++ans_tmp;
                } else {
                    if (ans < ans_tmp) {
                        ans = ans_tmp;
                    }
                    ans_tmp = 1;
                }
            }
            if (ans < ans_tmp) {
                ans = ans_tmp;
            }
        }
        return ans;
    }

    public static int solution(String[][] board, int n) {
        String temp;
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j < n - 1) {
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                    if (ans < check(board, n)) {
                        ans = check(board, n);
                    }
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
                if (i < n - 1) {
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                    if (ans < check(board, n)) {
                        ans = check(board, n);
                    }
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];
        for (int i = 0; i < n; ++i) {
            board[i] = br.readLine().split("");
        }
        ans = solution(board, n);
        bw.write(ans + "\n");
        bw.flush();
    }
}
