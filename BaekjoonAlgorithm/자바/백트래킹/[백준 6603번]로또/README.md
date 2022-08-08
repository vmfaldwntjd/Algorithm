문제 링크: https://www.acmicpc.net/problem/6603
- - -
## 고찰 및 해결 과정
### 방법 1
- 이 문제는 오름차순으로 입력된 수열이 주어졌을 때 나올 수 있는 모든 경우의 수열을 출력하는 문제로 보면 된다.  
- 첫 번째로 해결한 방법은 [N과 M (2)의 해결 과정](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9/%5B%EB%B0%B1%EC%A4%80%2015650%EB%B2%88%5DN%EA%B3%BC%20M%20(2))의 방법1과 똑같다.  
- 예제 1의 ```[1 2 3 4 5 6 7]```이 주어진 경우를 살펴보자.  
  - 먼저 맨 앞 숫자 1을 선택한 경우를 선택을 했다고 가정을 해보자.  
    ```TEXT
    1 _ _ _ _ _ _
    ```
  - 7개의 수열 중 6개를 선택하여 오름차순으로 나열해야 하고 1옆에 1이 오는 경우와 같이 중복을 허용하면 안되고 큰 수가 와야 하므로 1 뒤에 올 수 있는 경우는 다음과 같다.  
    ```TEXT
    1 2 _ _ _ _
    1 3 _ _ _ _
    1 4 _ _ _ _
    1 5 _ _ _ _
    1 6 _ _ _ _
    1 7 _ _ _ _
    ```
  - 1 뒤에 4이상이 오는 경우는 **수열을 6개 나열하는 것이 불가능**하므로 뒤에 올 수 있는 경우는 **2와 3뿐이다.**  
  - 이렇게 각 자리마다 자연수를 넣을 때 재귀 호출 방식을 통해서 수열을 만드는 방식으로 문제를 해결할 수가 있다. 다음은 재귀 함수 코드 내용이다.  
  ```JAVA
    static int[] arr = new int[14]; //수열의 결과를 나열할 배열
    static int[] num = new int[14]; //자연수를 입력받을 배열
    public static StringBuilder seq(int idx, int start, int n, int m) throws IOException { //매개변수에서 idx, start의 처음 값은 0이다. 
        if (idx >= m) { //idx는 arr의 인덱스를 가리키는 변수이고, idx가 m(6)과 같아지면 6개 다 수열을 만들었다는 의미이다.  
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(num[arr[i]]); //sb에 수열을 담는다. 
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder(); //수열의 결과를 담을 result
        for (int i = start; i < n; ++i) { // 1 _ _ _ _ _ 에서 1다음 칸에 올 수 있는 자연수는 start이다. 
            arr[idx] = i;
            result.append(seq(idx + 1, i + 1, n, m)); //start에 i + 1을 통해서 오름차순으로 처리한다. 
            arr[idx] = 0;
        }
        return result;
    }
  ```
- - -
### 방법 2
- 또 다른 방법은 어떤 자연수를 선택했을 경우와 선택하지 않았을 경우 두 가지의 경우를 통해서 해결하는 방법이 있다.  
- 이 문제도 [N과 M (2)의 해결 과정](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9/%5B%EB%B0%B1%EC%A4%80%2015650%EB%B2%88%5DN%EA%B3%BC%20M%20(2))의 방법 2와 똑같다.  
- 마찬가지로 예제 1의 ```[1 2 3 4 5 6 7]```이 주어진 경우를 살펴보자.  
- 이번에는 각 자연수가 **선택되거나 선택되지 않았을 경우**에 나열할 수 있는 **6개의 수열 조합이 있으면 수열을 출력하는 방식으로 문제를 해결**할 수가 있다.  
- 각 자연수마다 선택하거나 선택하지 않는 2가지의 경우가 존재하므로 시간 복잡도는 O(2^N)이라고 할 수가 있다.  
- 선택하거나 선택하지 않는 경우도 재귀함수를 통해서 구현하면 된다. 코드는 다음과 같다.  
```JAVA
    static int[] arr = new int[14]; //자연수를 입력받을 공간
    static int[] num = new int[14]; //수열을 나열할 공간
    public static StringBuilder seq(int idx, int selected, int n, int m) throws IOException { //매개변수에서 idx, selected는 0부터 시작한다. m은 6이 들으간다. 
        if (selected >= m) { //selected가 6개를 가리키고 있다면 수열을 출력해야 한다. 
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
        if (idx >= n) //모두 선택되지 않고, 입력받은 자연수의 개수를 넘어가는 경우도 존재하므로 그런 경우 예외처리를 한다. 
            return result;
        arr[selected] = num[idx]; //selected인덱스에 num[idx]를 입력받는다. 이는 num의 한 자연수를 선택했다는 의미이다.  
        result.append(seq(idx + 1, selected + 1, n, m)); //자연수 하나가 선택했을 경우의 재귀 호출이다. 
        arr[selected] = 0; //재귀 호출을 나오면 해당 자리는 다시 0으로 원위치 그렇게 되면 자연수는 선택받지 않는 경우가 된다.  
        result.append(seq(idx + 1, selected, n, m)); //자연수 하나를 선택하지 않았을 경우의 재귀 호출이다.  
        return result;
    }
```
