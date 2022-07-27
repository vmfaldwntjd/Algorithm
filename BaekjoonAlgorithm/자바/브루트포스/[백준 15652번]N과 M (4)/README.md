문제링크: https://www.acmicpc.net/problem/15652  
- - -
# 고찰 및 해결과정
## 첫 번째 방법(Main.java)
- 이 문제는 N까지의 자연수들 중에서 M개를 선택하는데 오름차순이면서 중복이 가능한 "비내림차순"형태로 수열을 만들어야 한다.  
- 나는 이 문제를 재귀함수를 사용해서 해결하였다.  
- 코드로 주석을 첨부하면서 문제를 설명하겠다. 다음 코드는 재귀 호출을 하는 함수의 내용이다.  
```JAVA
public static void print(int[] arr, int idx, int start, int n, int m) throws IOException {
        if (idx >= m) { //만약 idx가 m을 가리키고 있다면 이미 m개만큼 arr이 다 찼다는 얘기가 된다.  
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) { //수열 출력 부분
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = start; i <= n; ++i) {//i의 시작점을 start로 지정한다. 비내림차순 유지를 하기 위함이다. 
                arr[idx] = i; //특정 위치에 어떤 수를 담았으면 이제 재귀 호출을 한다.  
                print(arr,idx + 1, i, n, m); //특정 자리에 수를 넣었으니 idx를 업데이트 하고, start자리에는 자기 자신의 수를 넣는다.  
                arr[idx] = 0; //재귀 호출이 끝났으면 이미 수열 출력을 완료했다는 의미이므로 현재 자리는 다시 원래 수로 초기화 한다.  
            }
        }
```
  -> arr은 특정 수열을 담기 위한 배열이다.  
  -> idx는 특정 수를 담을 arr의 위치를 가리킬 변수이다.  
  -> start는 "비내림차순"의 수열을 유지하기 위해서 사용되는 변수이다.  
  -> 예를 들어 어떤 4자리 수열 _ _ _ _가 있을 때 1 _ _ _에서 1다음에 올 수 있는 숫자는 1과 같은 수이면서 큰 수이다.  
  -> 1 다음에 오는 자리의 수를 담기 위한 기준 역할을 하는 것이 start이다.  
- - -
## 두 번째 방법(Main2.java)
- 