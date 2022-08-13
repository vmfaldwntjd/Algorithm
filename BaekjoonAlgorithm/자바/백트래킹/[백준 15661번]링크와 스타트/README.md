문제 링크: https://www.acmicpc.net/problem/15661
- - -
## 고찰 및 해결 과정
- 이 문제는 [[백준 14889번]스타트와 링크](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9/%5B%EB%B0%B1%EC%A4%80%2014889%EB%B2%88%5D%EC%8A%A4%ED%83%80%ED%8A%B8%EC%99%80%20%EB%A7%81%ED%81%AC) 해결 과정과 풀이법이 전반적으로 비슷하다.  
- 한 가지 차이가 있다면 두 팀의 인원수가 같지 않아도 된다는 점이다.  
- 그래서 재귀함수의 코드의 내부 중 일부를 변경하였다.  
- 다음은 재귀 함수의 코드를 통해서 내용을 설명하겠다.  
```JAVA
 public static int solution(int[][] s, int idx, ArrayList<Integer> first_team, ArrayList<Integer> second_team) { //s는 입력받은 능력치정보, idx는 팀원의 번호라고고 보면 된다. 나는 처음에 0으로 초기화를 하였다.  
        if (idx == n) {//n은 총 인원 수를 의미한다.
            if (first_team.size() >= n - 1 || second_team.size() >= n - 1)
                return -1; //만약 first_team과 second_team의 인원이 서로 맞지 않는다면 능력치를 구해줄 필요가 없다. 
            int t1 = 0, t2 = 0; //t1: first_team의 능력치, t2: second_team의 능력치
            for (int i = 0; i < first_team.size(); ++i) {
                for (int j = 0; j < first_team.size(); ++j) {
                    if (i != j) //능력치를 구해주는 작업
                        t1 += s[first_team.get(i)][first_team.get(j)];
                }
            }
            for (int i = 0; i < second_team.size(); ++i) {
                for (int j = 0; j < second_team.size(); ++j) {
                    if (i != j)
                        t2 += s[second_team.get(i)][second_team.get(j)];
                }
            }
            int diff = Math.abs(t1 - t2); //두 팀의 능력치 차이를 구함
            return diff;
        }
        int result = -1; //결과를 반환할 변수 처음에는 -1로 초기화 
        first_team.add(idx); //first_team에 팀원 추가
        int t1 = solution(s, idx + 1, first_team, second_team); //다음 번호로 갱신하며 재귀 호출
        if (result == -1 || (t1 != -1 && t1 < result))  //능력치 차이의 최솟값을 추출하는 작업
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
