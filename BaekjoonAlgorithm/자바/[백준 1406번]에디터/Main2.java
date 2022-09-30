import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 입력 첫째 줄: 문자열, 둘째 줄: 입력할 명령어 개수, 그 다음 줄: 입력한 명령어 개수 만큼의 명령어 입력
         */
        /**
         * 1. 문자열을 연결리스트로 서로 연결을 진행
         * 2. 커서가 맨 왼쪽에 존재: 연결리스트에서 선택된 노드는 없다.
         * 3. L: 커서를 왼쪽으로 이동 -> 이전 노드로 하나 이동(이전 노드에 위치)
         * 4. D: 커서를 오른쪽으로 이동 -> 다음 노드로 하나 이동(다음 노드에 위치)
         * 5. B: 커서 왼쪽에 있는 문자를 삭제 -> 현재 노드의 이전 노드를 하나 지워줌
         * 6. P $: $문자를 커서 왼쪽에 추가 -> 현재 노드 이전 노드에 새로운 노드를 하나 추가
         */
        //문자열을 리스트로 만들어주기
        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        //정수 입력 받고 그 정수 횟수 동안 명령어 입력을 받기
        int m = Integer.parseInt(br.readLine());
        int cursor = list.size();
        for (int i = 0; i < m; ++i) {
            //명령어 입력 받기
            String cmd = br.readLine();
            if (cmd.charAt(0) == 'L' && cursor != 0) {
                --cursor;
            } else if (cmd.charAt(0) == 'D' && cursor != list.size()) {
                ++cursor;
            } else if (cmd.charAt(0) == 'B' && cursor > 0) {
                //현재 노드를 삭제
                list.remove(cursor-- - 1);
            } else if (cmd.charAt(0) == 'P') {
                //오른쪽에 데이터를 추가
                list.add(cursor++, cmd.charAt(2));
            }
        }
        //최종 결과 출력
        for (int i = 0; i < list.size(); ++i) {
            bw.write(list.get(i));
        }

        bw.flush();
    }
}