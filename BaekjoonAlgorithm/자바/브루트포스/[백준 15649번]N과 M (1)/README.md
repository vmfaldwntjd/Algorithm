문제 링크: https://www.acmicpc.net/problem/15649
- - -
## 고찰 및 해결 과정  
- 이 문제는 수열 문제로 1부터 N까지의 자연수 중 M개를 선택해서 나올 수 있는 수열의 경우를 모두 출력하는 문제이다.  
- 그래서 나는 이 모든 경우의 수열을 출력하기 위해서 재귀 함수를 선언해서 문제를 해결하였다.  
- 재귀함수의 코드를 보면 다음과 같다.  
```JAVA
public static void print(int idx, int[] arr, boolean[] check, int n, int m) throws IOException {
        if (idx >= m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (check[i] == true)
                continue;
            check[i] = true;
            arr[idx] = i;
            print(idx + 1, arr, check, n, m);
            check[i] = false;
        }
    }
```
