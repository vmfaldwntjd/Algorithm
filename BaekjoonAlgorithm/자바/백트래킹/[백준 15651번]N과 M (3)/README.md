문제 링크: https://www.acmicpc.net/problem/15651
- - -
# 고찰 및 해결 과정
- 이 문제는 중복 순열 문제로 모든 경우의 수를 다 출력을 하면 된다.  
- 나는 이 문제를 재귀함수를 사용하여 해결하였다.  
- 재귀함수에서 StringBuilder 인스턴스를 사용하였는데 그 이유는 일반적인 출력 방식으로는 시간 초과가 났기 때문이다.  
- 코드로 설명을 첨부하겠다. 아래 코드는 만든 재귀함수에 대한 코드이다.  
  ```JAVA
  public static StringBuilder print(int idx, int[] arr, int n, int m) throws IOException {
        if (idx >= m) { //만약 인덱스의 번호 idx가 m과 같아지면 m의 개수가 다 찼다는 얘기가 되므로 수열을 StringBuilder에 담아야 한다.  
            StringBuilder sb = new StringBuilder(); 
            for (int i = 0; i < m; ++i) {
                sb.append(arr[i]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            arr[idx] = i; //arr의 idx 자리에 자연수 i를 삽입
            result.append(print(idx + 1, arr, n, m)); //인덱스 idx를 업데이트 하면서 다시 재귀 호출
        }
        return result;
    }
  ```
  -> arr은 수열을 출력하기 위한 변수이다.  
  -> idx를 이용해서 수열 arr의 다음 위치를 정할 것이고, i를 통해서 arr에 수를 담을 것이다.  
  