문제 링크: https://www.acmicpc.net/problem/15663
- - -
## 고찰 및 해결 과정
### 방법1
- 이 방식은 참고하였고, 나는 방법 2를 통해서 문제를 해결하였다.  
- 수열을 입력받고 중복을 제거하는 방법으로 풀 수가 있다.  
- 과정 설명은 다음과 같다.  
  1. 먼저 수열을 입력받는다. 이 때의 수열 상태는 중복을 포함한다.  
  2. 입력된 수열과 입력된 N과 M을 바탕으로 나올 수 있는 모든 수열의 경우를 만들어낸다.  
  3. 중복에 의해서 몇 개의 똑같은 수열들이 나올 것이다.  
  4. 그러면 나올 수 있는 수열의 모든 경우의 수를 담을 큰 공간을 마련하고 이 중에서 중복을 제거하는 작업을 시작한다.  
- 코드를 통해서 설명을 하겠다. 나는 나올 수 있는 모든 경우의 수열을 담을 공간의 class를 하나 더 생성하였다.  
  -> 참고로 코드에 있는 arr, input, check, d는 전역 변수로 지정을 해주었다.  
  #### 메인 함수의 내용
  ```JAVA
   public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); //N과 M을 입력 받는다. 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()); //가공할 수열의 목록들을 입력한다. 
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n); //오름차순 정렬
        seq(0, n, m); //재귀함수를 통해서 나올 수 있는 모든 수열의 경우를 Result형 인스턴스에 담는다. 
        Collections.sort(d); //모든 수열의 경우도 오름차순으로 정렬을 해준다. -> 이 때 주의할 점은 정렬의 기준이 내림차순인지, 오름차순인지는 Result의 compareTo가 결정을 한다. 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.size(); ++i) { //현재 d에는 나올 수 있는 수열의 경우들이 들어 있을 것이다.
            if (i == 0 || !d.get(i).equals(d.get(i - 1))) { //만약 첫 인덱스이거나 현재 보고 있는 자리의 수열이 앞 수열과 다르다면
                for (int j = 0; j < m; ++j) { //수열을 담아준다. 
                    sb.append(d.get(i).get(j));
                    if (j != m - 1)
                        sb.append(" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb + "\n"); //담은 모든 수열의 경우를 모두 출력 진행
        bw.flush();
    }
  ```

  #### 재귀 함수 seq 내용
  ```JAVA
  public static void seq(int idx, int n, int m) {
        if (idx >= m) { //만약 보고 있는 자리 idx가 m과 같다면 수열을 담아야 한다.  
            ArrayList<Integer> temp = new ArrayList<>(); //정수형 리스트를 하나 만들어준다. 
            for (int i = 0; i < m; ++i)
                temp.add(input[arr[i]]); //정수형 리스트의 수열의 내용을 담는다. 
            d.add(new Result(temp)); //만든 수열의 결과를 수열들을 담을 공간 d에 담아준다. 
            return;
        }

        for (int i = 0; i < n; ++i) { //재귀 호출 사용
            if (check[i] == false) { // 수열의 값들의 중복을 방지하기 위해서 check를 사용 check[i]가 false이면 num[arr[idx]]를 아직 살펴보지 않았다.  
                arr[idx] = i;
                check[i] = true;
                seq(idx + 1, n, m);
                arr[idx] = 0;
                check[i] = false; //참고하고 수열까지 잘 담았으므로 다시 false 처리를 해준다.  
            }
        }
    }
  ```

  #### class Result 내용
    ```JAVA
    class Result implements Comparable<Result> {

        Integer[] a;

        Result(ArrayList<Integer> a) { //생성자를 통해서 Integer[] 타입의 배열 a를 만들어준다. 
            this.a = a.toArray(new Integer[a.size()]);
        }

        @Override
        public boolean equals(Object obj) { //수열의 내용이 같은지 다른지 비교하는 함수
            if (obj instanceof Result) {
                Result that = (Result)obj;
                int n = this.a.length;
                for (int i = 0; i < n; ++i)
                    if (this.a[i] != that.a[i])
                        return false;
                return true;
            } else
                return false;
        }

        public int get(int idx) { //수열의 위치 idx에서의 값을 반환해주는 메서드
            return (int)this.a[idx];
        }

        public int compareTo(Result that) { //이 메서드는 Comparable<Result>에 의해서 반드시 있어야 하는 메서드이다. 이것은 수열의 내용들을 기준으로 수열을 오름차순으로 정렬할지 내림차순으로 정렬할지 결정한다.
            int n = this.a.length;
            for (int i = 0; i < n; ++i) {
                if (this.a[i] == that.a[i])
                    continue;
                if (this.a[i] < that.a[i]) //내림차순 처리
                    return -1;
                if (this.a[i] > that.a[i]) //오름차순 처리
                    return 1;
            }
            return 0;
        }
    }
    ```
- - -
### 방법2
- 수열을 입력 받고 특정 수열의 값이 몇 번 입력을 받았는지 확인하는 방식으로 중복을 제거하면서 문제를 해결할 수가 있다.  
- 과정은 이렇다.  
  1. 먼저 중복을 포함한 특정 수들을 입력받는다.  
  2. 입력을 받은 수들 각각 몇 번 반복되었는지 그 정보를 저장한다.  
  3. 재귀 함수를 통해서 입력 받은 횟수를 하나씩 줄여가면서 수열을 출력하면 문제를 해결할 수가 있다.  
- 코드를 통해서 해결 과정을 설명하겠다.  
  -> 정수형 배열 arr, num, cnt은 전역 변수로 지정이 된 상태이다.  
  -> num은 중복되지 않은 자연수들을 담을 공간이다.  
  -> cnt는 num의 특정 자리의 값이 몇 번 바뀌었는지 정보를 저장할 공간이다.  
  -> arr은 수열의 결과를 출력할 공간이다.  
#### 메인 함수의 내용
  ```JAVA
  public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); //N과 M을 입력받는다. 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] input = new int[9];
        st = new StringTokenizer(br.readLine()); //자연수들 입력 받기
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input, 0, n);
        int k = 0; //num의 인덱스를 지정할 변수
        int x = input[0]; //입력된 자연수의 첫 번째 값을 x로 초기화
        int c = 1; //카운트는 1로 초기화
        for (int i = 1; i < n; ++i) {
            if (x == input[i]) { //만약 현재 자리의 값 input[i]가 x와 같다면 카운트
                c += 1;
            } else { //다르다면
                num[k] = x; //중복되지 않은 수열을 담을 공간에 x를 넣어준다.  
                cnt[k++] = c; //특정 자리 안의 값이 몇 번 중복되었는지 기록
                x = input[i]; //x 값 업데이트
                c = 1; //카운트는 1로 다시 초기화
            }
        }
        num[k] = x; //마지막 자리에 마지막으로 업데이트 된 x값을 넣어준다. 
        cnt[k] = c; //카운트 정보도 넣어준다.  
        n = k + 1; //n을 중복이 안 된 실제 자연수의 개수로 업데이트 
        bw.write(seq(0, n, m) + "\n");
        bw.flush();
    }
  ```

#### 재귀 함수 seq 내용
  ```JAVA
  public static StringBuilder seq(int idx, int n, int m) {
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; ++i) {
                sb.append(num[arr[i]]);
                if (i != m - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > 0) { //만약 현재 자리의 카운트가 0보다 크다면
                cnt[i] -= 1; //카운트 하나 감소
                arr[idx] = i;
                result.append(seq(idx + 1, n, m));
                cnt[i] += 1; //수열 출력을 완료했으므로 다시 원상태로 복구한다.  
            }
        }
        return result;
    }
  ```
  
