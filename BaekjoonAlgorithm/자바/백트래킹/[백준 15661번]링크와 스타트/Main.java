import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static int solution(int[][] s, int idx, ArrayList<Integer> first_team, ArrayList<Integer> second_team) {
        if (idx == n) {
            if (first_team.size() >= n - 1 || second_team.size() >= n - 1)
                return -1;
            int t1 = 0, t2 = 0;
            for (int i = 0; i < first_team.size(); ++i) {
                for (int j = 0; j < first_team.size(); ++j) {
                    if (i != j)
                        t1 += s[first_team.get(i)][first_team.get(j)];
                }
            }
            for (int i = 0; i < second_team.size(); ++i) {
                for (int j = 0; j < second_team.size(); ++j) {
                    if (i != j)
                        t2 += s[second_team.get(i)][second_team.get(j)];
                }
            }
            int diff = Math.abs(t1 - t2);
            return diff;
        }
        int result = -1;
        first_team.add(idx);
        int t1 = solution(s, idx + 1, first_team, second_team);
        if (result == -1 || (t1 != -1 && t1 < result))
            result = t1;
        first_team.remove(first_team.size() - 1);
        second_team.add(idx);
        int t2 = solution(s, idx + 1, first_team, second_team);
        if (result == -1 || (t2 != -1 && t2 < result))
            result = t2;
        second_team.remove(second_team.size() - 1);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][n];
        ArrayList<Integer> first_team = new ArrayList<>();
        ArrayList<Integer> second_team = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            s[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(solution(s, 0, first_team, second_team) + "\n");
        bw.flush();
    }
}
