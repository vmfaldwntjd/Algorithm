문제 링크: https://www.acmicpc.net/problem/2529
- - -
## 고찰 및 해결 과정
- 이 문제는 [N과 M (1)](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9/%5B%EB%B0%B1%EC%A4%80%2015649%EB%B2%88%5DN%EA%B3%BC%20M%20(1))과 [암호 만들기](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9/%5B%EB%B0%B1%EC%A4%80%201759%EB%B2%88%5D%EC%95%94%ED%98%B8%20%EB%A7%8C%EB%93%A4%EA%B8%B0)의 코드 풀이를 응용한 문제이다.  
- 일반적인 수열 및 암호를 나열하는 방식과는 다르게 부등호의 나열에 맞게 알맞은 자연수들을 나열해야 한다.  
- 그리고 나열된 자연수를 서로 붙여서 하나의 자연수로 만들어서 최소, 최댓값을 구해야 한다.  
- 재귀 함수를 사용하여 문제를 해결  
- 모든 경우의 수를 탐색하기에는 다소 시간이 오래 걸릴 수 있으므로 불필요한 경우를 제거하기 위한 방법을 고찰  
  - 예를 들어 예제 입력 2의 경우를 살펴보면 ```> < < < > > > < <```의 경우에서 재귀 호출을 통해서 자연수를 입력하는 경우는 다음과 같다.  
    ```
    재귀 호출 전: 0> < < < > > > < <
    재귀 호출 후: 0>0< < < > > > < <
    ```
  - 이렇게 다음 자리를 볼 때마다 재귀 호출을 사용하는 방식인데 첫 번째 부등호의 경우가 성립하지 않다면 뒤의 나머지 부등호는 살펴볼 이유가 없다.  
  - 이러한 불필요한 경우들을 보지 않기 위해 백트랙킹 방법을 사용하였다.   
- 코드 내용은 다음과 같다.  
```JAVA
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<String> result = new ArrayList<>(); //부호에 따라 만든 문자형 자연수들의 배열
    public static boolean isValid(char a, char b, char op) { // 부등호에 맞게 설정이 되었는지 확인할 메서드
        if ((op == '<' && a > b) || (op == '>' && a < b))
            return false;
        return true;
    }
    public static void solution(char[] c, boolean[] check, int idx, int m, String s) {
        if (idx >= m) { //만약 m개에 도달했다면 자연수 문자열이 만들어진 것으로 result에 문자열을 넣어준다. 
            result.add(s);
            return;
        }
        for (int i = 0; i < 10; ++i) { //부등호 양옆에 들어갈 수 있는 자연수는 0부터 9까지이다. 
            if (check[i] == false) { //한번 나열된 자연수가 아니라면
                if (idx == 0 || isValid(s.charAt(idx - 1), (char)(i + '0'), c[idx - 1])) { //백트래킹 처리
                    check[i] = true; //나열된 자연수임을 표시
                    solution(c, check, idx + 1, m, s + Integer.toString(i)); //다음 자리로 넘어가며 재귀호출
                    check[i] = false; //다시 새로운 자연수를 넣어줄 것이므로 이 자리는 다시 false로 원위치
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        char[] c = new char[k]; //부등호 입력 자리
        boolean[] check = new boolean[10]; //자연수의 중복나열을 방지하기 위한 check 배열이다. 
        String[] input = br.readLine().split(" "); //부등호의 문자열을 입력
        for (int i = 0; i < k; ++i)
            c[i] = input[i].toCharArray()[0]; //문자열로 입력한 부등호들을 하나의 문자 배열로 변경해주었다. 
        solution(c, check, 0, k + 1, ""); //재귀 호출 함수 사용 -> (부등호 배열, 자연수 중복 확인 배열, 들어갈 자연수의 개수 0으로 초기화, 총 자연수의 개수, 자연수들을 서로 붙여서 만들 새로운 자연수(문자열로 결과를 반환))
        Collections.sort(result); //result에 문자열의 배열이 담겼을 것이므로 사전순으로 정렬
        bw.write(result.get(result.size() - 1) + "\n"); //최댓값 출력
        bw.write(result.get(0) + "\n"); //최솟값 출력
        bw.flush();
    }
}
```
