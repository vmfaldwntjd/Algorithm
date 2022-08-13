문제 링크: https://www.acmicpc.net/problem/14889
- - -
## 고찰 및 해결 과정
- 문제에 있는 내용대로 4명의 팀이 있다고 가정을 할 때 맺을 수 있는 팀원의 수는 N/2가 성립해야 하므로 2명이어야 한다.  
- N의 최댓값은 20으로 20명 중에서 10명을 고르는 경우의 수는 184756이다.  
- 1억의 연산 횟수당 1초가 걸린다고 가정을 했을 때 이는 그렇게 오래 걸리는 시간은 아니다.  
- 따라서 모든 경우를 다 둘러보면서 문제를 해결할 수가 있다.  
- 나는 다음과 같은 과정으로 문제를 해결하였다.  
  1. 문제와 같이 팀 능력치의 정보를 입력할 2차원 배열 s를 만들어준다.  
  2. 두 팀으로 나누기 위한 리스트**first_team**과 **second_team**을 각각 만들어준다.  
  3. 두 리스트에 있는 팀원 수가 전체 인원 수의 절반으로 숫자가 맞춰지면 각 팀에서 능력치를 구해준다.  
  4. 그리고 각 팀의 능력치 차이를 구해주고 최솟값을 추출할 수 있도록 한다.  
  5. 그리고 팀의 구성을 바꿔가며 3번과 4번의 과정을 반복한다.  
  6. 반복하는 과정은 재귀호출 방식을 사용했다.  
- 재귀 함수의 코드 내용은 다음과 같다.  
```JAVA
public static int solution(int[][] s, int idx, ArrayList<Integer> first_team, ArrayList<Integer> second_team) { //idx는 팀원의 번호라고고 보면 된다. 나는 처음에 0으로 초기화를 하였다. 
        if (idx == n) { //n은 총 인원 수를 의미한다.
            if (first_team.size() != n / 2 || second_team.size() != n / 2)
                return -1; //만약 first_team과 second_team의 인원이 서로 맞지 않는다면 능력치를 구해줄 필요가 없다. 
            int t1 = 0, t2 = 0; //t1: first_team의 능력치, t2: second_team의 능력치
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    if (i != j) { //능력치를 구해주는 작업
                        t1 += s[first_team.get(i)][first_team.get(j)];
                        t2 += s[second_team.get(i)][second_team.get(j)];
                    }
                }
            }
            int diff = Math.abs(t1 - t2); //두 팀의 능력치 차이를 구함
            return diff;
        }
        if (first_team.size() > n / 2 || second_team.size() > n / 2)
            return -1; //만약 어느 팀 중 하나가 n / 2가 넘어가버리면 팀 능력치를 구해줄 필요가 없으므로 백트래킹 처리
        int result = -1; //결과를 반환할 변수 처음에는 -1로 초기화 
        first_team.add(idx);//first_team에 팀원 추가
        int t1 = solution(s, idx + 1, first_team, second_team); //다음 번호로 갱신하며 재귀 호출
        if (result == -1 || (t1 != -1 && t1 < result)) //능력치 차이의 최솟값을 추출하는 작업
            result = t1;
        first_team.remove(first_team.size() - 1); //팀원 재구성을 위해서 first_team의 팀원 한 명을 빼준다. 
        second_team.add(idx); //두 번째 팀에 팀원을 추가
        int t2 = solution(s, idx + 1, first_team, second_team); //다음 번호로 갱신하며 재귀 호출
        if (result == -1 || (t2 != -1 && t2 < result)) //능력치 차이 최솟값 호출
            result = t2;
        second_team.remove(second_team.size() - 1); //팀원 재구성을 위해서 팀원 한 명 추출
        return result;
    }
```