import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] grade = new int[7][2]; //첫 번 째 자리는 학년, 두 번째 자리는 성별 관련
        int answer = 0;//결과 출력용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//학생 수
        int k = Integer.parseInt(st.nextToken());//한 방에 배정할 수 있는 최대 인원 수
        for (int i = 0; i < n; ++i) {//n명의 학생의 성별과 학년 정보를 입력 받아서 grade에 정보를 추가한다.
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ++grade[y][s];
        }
        for (int i = 1; i <= 6; ++i) {
            for (int j = 0; j < 2; ++j) {
                answer += grade[i][j] / k;//특정 학년 및 성별의 학생 수를 방 배정할 수 있는 최대 인원 수 k로 나눈 몫을 계산함으로써 방의 최소 계수를 세준다.
                if (grade[i][j] % k > 0) {// 나머지가 존재한다면 남는 학생이 있다는 얘기이므로 그 학생을 위한 방을 추가해준다.
                    ++answer;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}