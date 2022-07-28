문제 링크: https://www.acmicpc.net/problem/15649
- - -
## 고찰 및 해결 과정  
- 이 문제는 수열 문제로 1부터 N까지의 자연수 중 M개를 선택해서 나올 수 있는 수열의 경우를 모두 출력하는 문제이다.  
- 그래서 나는 이 모든 경우의 수열을 출력하기 위해서 재귀 함수를 선언해서 문제를 해결하였다.  
- 재귀함수의 코드와 주석으로 설명을 첨부하겠다.  
```JAVA
public static void print(int idx, int[] arr, boolean[] check, int n, int m) throws IOException {
        if (idx >= m) { //idx가 m에 도달하면 인덱스 0부터 m - 1까지의 arr 수열 내용을 모두 출력을 한다. 
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (check[i] == true) //이미 arr에 특정 숫자 i가 담겨져 있다면 arr에 다시 담을 필요가 없다. 
                continue;
            check[i] = true; //i가 arr에 담겨져 있지 않은 수라면 arr에 수를 담고 check에 true 처리를 진행
            arr[idx] = i; //arr의 idx자리에 특정 수 i를 넣어준다. 
            print(idx + 1, arr, check, n, m); //idx를 하나씩 올려가며 재귀호출
            check[i] = false; //다 배열을 출력을 했으면 check i자리를 false처리를 해서 다시 새로운 수열을 만들어 줄 수 있도록 한다.  
        }
    }
```
  -> arr은 특정 수열을 출력하기 위해서 담을 배열이다.  
  -> check는 특정 숫자가 arr에 이미 담겨진 수는 아닌지 확인하기 위한 boolean 배열이다.  
  -> idx를 이용해 arr의 특정 인덱스를 지정하여 그 지점에 자연수를 넣어줄 것이다.  
  