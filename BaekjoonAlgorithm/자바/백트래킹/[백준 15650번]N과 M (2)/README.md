문제 링크: https://www.acmicpc.net/problem/15650
- - -
# 고찰 및 해결 과정
## 첫 번째 방법(Main.java)  
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
            arr[idx] = i; //arr의 idx자리에 특정 수 i를 넣어준다.  
            print(idx + 1, i + 1, arr, check, n, m); //idx와 i를 각각 하나씩 올려가며 재귀호출을 진행  
            arr[idx] = 0; //수열의 특정 자리에 있는 숫자도 초기화  
        }
    }
```
  -> arr은 특정 수열을 출력하기 위한 자연수를 담을 배열이다.  
  -> idx를 이용해 arr의 특정 인덱스를 지정하여 그 지점에 자연수를 넣어줄 것이다.  
  -> start는 arr의 담길 수열의 중복을 방지하고 오름차순으로 담기 위해서 지정한 변수이다.  
- 시간 복잡도를 N이 5, M이 3인 경우를 예로 들어보며 계산해보면 다음과 같다.  
  ```
  1, 2, 3
  1, 2, 4
  1, 2, 5
     .
     .
     .
  ```
  -> 이런 경우의 수를 따져 보면 N X (N - 1) X (N - 2) X 1가지의 경우를 모두 돌아봐야 한다.  
  -> 즉 시간 복잡도는 O(N!)이라고 할 수가 있다.  
  -> 또한 M의 최댓값은 N개가 될 수 있기 때문에 N개 중에 N을 고르는 경우의 수라고 생각하면 된다.  
- - -
## 두 번째 방법(Main2.java)
- 앞의 예보다 좀 더 빠른 경우이다.  
- 예를 들어서 N이 4인 경우를 생각해보자.  
- 그럼 각각 1, 2, 3, 4에서 이 수들 중에서 각각 하나를 선택하고 안 한 경우를 생각을 해보자.  
- 그러면 나올 수 있는 경우의 수는 2^4가지가 되므로 **시간 복잡도는 O(2^N)으로 앞의 경우보다 빠르다는 것을 알 수가 있다**.  
- 코드로 설명을 하겠다.  
```JAVA
public static void print(int[] arr, int num, int selected, int n, int m) throws IOException {
        if (selected == m) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; ++i) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        if (num > n) //숫자를 모두 선택하지 않았을 경우 num이 N을 넘어가는 경우가 생기므로 예외처리를 해준다.  
            return;
        //숫자를 선택한 경우의 재귀 호출
        arr[selected] = num;
        print(arr, num + 1, selected + 1, n, m); //숫자를 선택했으므로 num과 selected를 모두 1증가하여 재귀 호출을 진행한다.  
        //숫자를 선택하지 않은 경우의 재귀 호출
        arr[selected] = 0;
        print(arr, num + 1, selected, n, m); //숫자를 아직 선택하지 않았으므로 selected는 그대로 놔두고 num만 업데이트 해서 재귀호출을 한다.  
    }
```
  -> arr은 특정 수열을 출력하기 위한 자연수를 담을 배열이다.  
  -> selected는 arr의 특정 위치를 가리킨다. 특정 위치에 숫자가 들어가면 선택된 것이므로 selected를 업데이트 해줘야 한다.  
  -> num은 arr에 들어갈 숫자를 말한다.  
  
