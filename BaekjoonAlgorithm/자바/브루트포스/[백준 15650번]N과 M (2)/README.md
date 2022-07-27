문제 링크: https://www.acmicpc.net/problem/15650
- - -
## 고찰 및 해결 과정
- 이 문제는 1부터 N까지의 자연수 중 M개를 선택해서 중복없이 오름차순으로 숫자를 고르는 방법이다.  
- 즉 이 문제는 조합의 문제이다.  
- 나는 이 문제를 재귀함수를 써서 문제를 해결하였다.    
- 재귀함수의 코드와 주석으로 설명을 첨부하겠다.  
```JAVA
public static void print(int idx, int start, int[] arr, boolean[] check, int n, int m) throws IOException {
        if (idx >= m) { //idx가 m에 도달하면 인덱스 0부터 m - 1까지의 arr 수열 내용을 모두 출력을 한다. 
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (check[i] == false) { //이미 arr에 특정 숫자 i가 담겨져 있지 않다면  
                arr[idx] = i; //arr의 idx자리에 특정 수 i를 넣어준다.  
                check[i] = true; //i가 arr에 담겨져 있으므로 i는 담겨져 있다고 check배열에 표시흘 한다.  
                print(idx + 1, i + 1, arr, check, n, m); //idx와 i를 각각 하나씩 올려가며 재귀호출을 진행  
                check[i] = false; //배열을 다 출력했으면 check자리에 i를 다시 false로 돌려 새로운 수열을 만들 수 있도록 해준다.  
                arr[idx] = 0; //수열의 특정 자리에 있는 숫자도 초기화  
            }
        }
    }
```
  -> arr은 특정 수열을 출력하기 위한 자연수를 담을 배열이다.  
  -> check는 특정 숫자가 arr에 이미 담겨진 수는 아닌지 확인하기 위한 boolean 배열이다.  
  -> idx를 이용해 arr의 특정 인덱스를 지정하여 그 지점에 자연수를 넣어줄 것이다.  
  -> start는 arr의 담길 수열의 중복을 방지하고 오름차순으로 담기 위해서 지정한 변수이다.  