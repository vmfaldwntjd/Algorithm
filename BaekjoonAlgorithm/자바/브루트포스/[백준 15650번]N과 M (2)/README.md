문제 링크: https://www.acmicpc.net/problem/15650
- - -
## 고찰 및 해결 과정
- 이 문제는 1부터 N까지의 자연수 중 M개를 선택해서 중복없이 오름차순으로 숫자를 고르는 방법이다.  
- 즉 이 문제는 조합의 문제이다.  
- 나는 이 문제를 재귀함수를 써서 문제를 해결하였다.    
- 재귀함수의 코드와 주석으로 설명을 첨부하겠다.  
```JAVA
public static void print(int idx, int start, int[] arr, boolean[] check, int n, int m) throws IOException {
        if (idx >= m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (check[i] == false) {
                arr[idx] = i;
                check[i] = true;
                print(idx + 1, i + 1, arr, check, n, m);
                check[i] = false;
                arr[idx] = 0;
            }
        }
    }
```
  -> arr은 특정 수열을 출력하기 위한 자연수를 담을 배열이다.  
  -> check는 특정 숫자가 arr에 이미 담겨진 수는 아닌지 확인하기 위한 boolean 배열이다.  
  -> idx를 이용해 arr의 특정 인덱스를 지정하여 그 지점에 자연수를 넣어줄 것이다.  
  -> start는 arr의 담길 수열의 중복을 방지하고 오름차순으로 담기 위해서 지정한 변수이다.  