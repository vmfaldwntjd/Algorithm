# 최백준 알고리즘 강의

- **자바 알고리즘 테스트 보기 전 숙지해야 할 것들 및 알게 된 사실**
    - 문자열, 정수 변환 관련 참조 사이트: [https://hianna.tistory.com/524#:~:text=Integer.toString()%2C String.,로 변환할 수 있습니다](https://hianna.tistory.com/524#:~:text=Integer.toString()%2C%20String.,%EB%A1%9C%20%EB%B3%80%ED%99%98%ED%95%A0%20%EC%88%98%20%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4).
    - **입력 관련**
        - BufferedReader에서 br.read()는 정수를 받는다.
        - BufferedReader를 사용해서 정수를 공백 입력을 받고 싶으면 다음과 같이 코드를 작성한다. → StringTokenizer 객체를 사용한다.(라이브러리는 java.util에 위치한다.) 단 이것은 공백 입력 받는 영역에서만 써야한다! 줄바꿈이 들어가는 입력을 하면 오류가 난다.
            
            ```java
            **import java.io.*;
            import java.util.StringTokenizer;
            
            public class Main {
            
                public static void main(String[] args) throws IOException {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
            
                    System.out.println(a);
                    System.out.println(b);
                }
            }**
            ```
            
        - 자바 정수 배열에서 배열의 모든 값을 특정 값으로 초기화하고 싶으면 Arrays.fill(d, 값)을 입력하면 된다.(d는 배열이다.)
    - **출력 관련**
        - BufferedWriter의 bw.write함수는 인자를 String 형태로 받아야지만 출력이 가능하다!
        - 문자열을 거꾸로 출력하고 싶을 때 사용했던 방식이다. StringBuilder sb, sb.reverse().toString();
        - StringBuilder의 replace 메서드는 sb 문자열의 특정 인덱스 시작부터, 끝지점의 문자열을 다른 문자열로 바꾸는 메서드이다. → replace(int start, int end, String rep);
        - String의 replace는 문자열에 있는 모든 특정 문자를 다른 문자로 전부 바꿔주는 메서드이다! → 이건 반환을 문자열로 해주므로 반환을 받아주는 변수가 따로 필요하다!
        - String.subString(int index)은 특정 index에서 끝까지의 문자열을 반환해준다. → 인덱스 끝 부분도 지정 가능하다.
    - **알게 된 사실**
        - 백준 ([https://www.acmicpc.net/problem/10828](https://www.acmicpc.net/problem/10828)) 문제 풀이 중 BufferedWriter 클래스의 new BufferedWriter(new OutputStreamWriter(System.out)) 에서 bc.write(변수)를 넣고 bc.write(변수 + “\n)을 입력했는데 bc.write(변수) 부분이 누락(?)되는 현상이 발생했다. 줄바꿈을 넣어주었더니 다 출력이 되었다. → 왜 그러는지는 아직 모르는 상태
        - c와는 달리 java는 if, while안에 들어가야 하는 조건들은 무조건 형태가 boolean 즉, true, false로 들어와야 한다! (숫자, 문자 등은 조건 안에 들어갈 수가 없다.)
        - Scanner의 nextInt()로 정수를 입력받고 Scanner의 nextLine()을 사용하면 nextLine()에서 줄바꿈을 받아버려서 제대로 된 입력 하나가 누락되는 현상이 발생한다!
        - 백준 [https://www.acmicpc.net/problem/9093](https://www.acmicpc.net/problem/9093): nextLine()으로 입력 받을 시 개행 문자까지 같이 받아버리고 싶으면 뒤에 + “\n”을 추가해주면 된다. → 종종 이런 방식으로 풀어야 정답 처리가 될 때가 있다.
        - [https://www.acmicpc.net/problem/9093](https://www.acmicpc.net/problem/9093): 문자열에 foreach를 적용하고 싶으면 ‘for (char ch : str.toCharArray())’ 방식을 사용한다.
        - parseInt는 숫자로 이루어진 문자열을 숫자형으로 바꿔주기 때문에 파라미터로 반드시 숫자만 넣어야 한다. 그리고 BufferedReader의 read()함수는 주어진 숫자를 8진법으로 바꿔서 출력을 해준다.
        - 자바의 배열을 선언하는 방법 공부하기 위해서 참조한 사이트: [https://coding-factory.tistory.com/253](https://coding-factory.tistory.com/253)
    - **알게 된 사실2**
        - System.out.println은 마지막에 줄바꿈을 자동으로 넣어주므로 출력시 줄바꿈을 안 넣고 싶으면 Stringbuilder 클래스의 append함수를 사용해서 문자열을 만들어주고 이를 System으로 한 번에 출력해주면 된다.
        - BufferedReader br의 readLine().split(” “)을 사용함으로써 “ “을 기준으로 문자열을 나눌 수가 있다. ex) String[] line = br.readLine().split(" ");
        - sc.nextInt()를 사용하고 문자열을 받을 시 버퍼에 담긴 줄바꿈을 먼저 담아버리므로 버퍼를 제거해줄 필요가 있다. → 그래서 nextInt() 대신에 Integer.parseInt(sc.nextLine()) 방식을 사용한다.
        - 자바는 문자열을 비교할 때 equals 함수를 사용한다.
        - 문자열 String.valueOf() 와 toString()의 차이점: 들어오는 인자가 null일 경우 toString()은 널포인트 에러를 발생시키지만 valueOf는 그대로 null을 반환한다. → String.valueOf()는 들어오는 인자를 문자열로 바꿔준다.
        
    - **배열 관련**
        - 자바는 c언어와는 달리 배열 선언할 때 int arr[4] = {1, 2, 3, 4}와 같은 선언은 할 수가 없다. 할거면 다음과 같은 선언을 한다.
        - **정수 배열은 사이즈를 구하고 싶으면 arr.length(arr.length() 아님!)을 쓴다. 문자열은 괄호를 붙여줘야 한다!**
            
            ```java
            //크기 할당 & 초기화 없이 배열 참조변수만 선언
            int[] arr;
            int arr[];
            
            // 선언과 동시에 배열 크기 할당
            int[] arr = new int[5];
            String[] arr = new String[5]; 
            
            // 기존 배열의 참조 변수에 초기화 할당하기
            int[] arr;
            arr = new int[5]; //5의 크기를 가지고 초기값 0으로 채워진 배열 생성
            
            // 선언과 동시에 배열의 크기 지정 및 값 초기화
            int[] arr = {1,2,3,4,5}; 
            int[] arr = new int[]  {1,3,5,2,4};    
            int[] odds = {1,3,5,7,9};  
            String[] weeks = {"월","화","수","목","금","토","일"};
            
            // 2차원 배열 선언
            int[][] arr = new int[4][3];   //3의 크기의 배열을 4개 가질 수 있는 2차원 배열 할당  
            int[][] arr9 = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {3, 4, 5}};
            //arr[0] >> {2, 5, 3};
            //arr[1] >> {4, 4, 1};
            //arr[2] >> {1, 7, 3};
            //arr[3] >> {3, 4, 5};
            ```
            
        - 자바는 배열 선언 시 아무 값도 안 넣어주면 자동으로 0으로 초기화를 해준다.
        - 정수 배열에서 특정값의 위치를 찾고 싶을 때([https://technote-mezza.tistory.com/99](https://technote-mezza.tistory.com/99))
        →**Arrays.asList(arr).indexOf("b")**
        - 숫자인 문자열로 이루어진 배열을 정수 배열로 변형하는 방법을 공부한 참조 사이트: [https://www.delftstack.com/ko/howto/java/java-convert-string-array-into-int-array](https://www.delftstack.com/ko/howto/java/java-convert-string-array-into-int-array/)
        → 내가 쓴 방식: `int[] arr = Arrays.*stream*(input).mapToInt(Integer::*parseInt*).toArray();`
        → 이 방식은 주의해야 할 점이 **primitive 타입으로 int를 선언을 해줘야 한다!**
        - 정수로 이루어진 배열 중(primative)에서 최댓값 또는 최솟값을 뽑고 싶으면 다음과 같이 입력하면 된다
        → Arrays.stream(d).max().getAsInt()
        - 실수(double)면 다음과 같이 입력한다. float는 적용이 안된다.→ Arrays.stream(d).max().getAsDouble()
        - Integer[] 배열로 선언한 경우 최댓값을 구하고 싶을 때 다음 방식을 사용해야 한다.
        → Collections.max(Arrays.asList(d))
        - 주의해야 할 점은 배열에서 최댓값을 구해주는 내장 함수는 “**List” 배열에서 존재하므로 만일 ArrayList로 선언을 하였다면 Arrays.asList(d)방식을 사용해야 한다! 이 때 d는 배열 형식이 Integer 타입 이어야 한다!!**
        - int[] arr 을 정렬하고 싶으면 다음 방식을 사용한다. → Arrays.sort(arr): 이 함수는 반환값이 따로 없어서 먼저 진행 후 arr을 출력해야 한다.
        - java는 c언어처럼 참조값 &을 못쓰기 때문에 배열과 인덱스를 파라미터로 넣어줘서 내용물을 직접 바꿔주어야 한다.
        - 베열에서 특정 인덱스의 값을 바꿔주고 싶을 때 나는 이 방식을 사용하였다. 
        → `Arrays.*fill*(num, idx, idx + 1, true);`  이 방식은 배열이 boolean으로 선언 되어 있는 경우이다.
        - 배열에서 어떤 값이 배열에 존재하는지 확인하는 메서드
        → Arrays.asList(arr).contains(value): 주의할 점은 이 때 배열이 **객체형으로 선언이 되어야 한다!!!! → int형 배열의 경우 Integer로 선언해야 한다!!**
        - ArrayList<Integer> temp = new ArrayList<>()로 선언했을 때 temp에 정수를 넣어주고 그냥 temp.toArray()를 사용했을 경우 아무런 문제는 없지만, 어떤 Integer[] 배열 arr에 대입을 하고 싶을 때는 toArray()에 파라미터를 입력을 해줘야 한다! → toArray(new Integer[temp.size()])
        - **예시코드**
            
            ```java
            import java.io.*;
            import java.util.*;
            
            public class Main {
            
                public static final void swap(int[][] arr, int i1, int j1, int i2, int j2) {
                    int temp = arr[i1][j1];
                    arr[i1][j1] = arr[i2][j2];
                    arr[i2][j2] = temp;
                }
                public static void main(String[] args) throws IOException {
                 
                    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            bw.write(arr[i][j] + " ");
                        }
                        bw.write("\n");
                    }
                    bw.write("\n");
                    swap(arr, 0, 2, 0, 1);
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            bw.write(arr[i][j] + " ");
                        }
                        bw.write("\n");
                    }
                    bw.flush();
                }
            }
            ```
            
    - **문자 관련**
        - char 타입의 정수를 진짜 정수로 바꾸고 싶으면 **Character.getNumericValue(ch)**를 사용! → Integer.ParseInt()사용 안된다.  아니면 ch - ‘0’사용!
        - 
    - 시스템 관련
        - 강제로 자바를 종료하고 싶으면 System.exit(0)을 사용하면 된다.
- **그 외의 내가 습득한 알고리즘**
    - **90도 회전 알고리즘**
        
        ```java
        **public static int[][] rotate90(int[][] board, int n, int m) {
                int[][] result = new int[m][n];
        
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        result[j][n - 1 - i] = board[i][j];
                    }
                }
                return result;
            }**
        ```
        
    - 180**도 회전 알고리즘**
        
        ```java
        **public static int[][] rotate180(int[][] board, int n, int m) {
                int[][] result = new int[n][m];
        
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        result[n - 1 - i][m - 1 - j] = board[i][j];
                    }
                }
                return result;
            }**
        ```
        
    - 270**도 회전 알고리즘**
        
        ```java
        **public static int[][] rotate270(int[][] board, int n, int m) {
                int[][] result = new int[m][n];
        
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        result[m - 1 - j][i] = board[i][j];
                    }
                }
                return result;
            }**
        ```
        
- **알고리즘 기초 1/2**
    - **알고리즘 시작**
        - 메모리 사용 관련
            
            ![Screen Shot 2022-07-05 at 10.23.44 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.23.44_AM.png)
            
            ![Screen Shot 2022-07-05 at 10.24.08 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.24.08_AM.png)
            
        - **입출력 관련 설명**
            
            ![Screen Shot 2022-07-05 at 10.25.03 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.25.03_AM.png)
            
            ![Screen Shot 2022-07-05 at 10.25.24 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.25.24_AM.png)
            
            ![Screen Shot 2022-07-05 at 10.26.15 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.26.15_AM.png)
            
        - **출력 관련 설명**
            
            ![Screen Shot 2022-07-05 at 10.26.58 AM.png](%E1%84%8E%E1%85%AC%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8C%E1%85%AE%E1%86%AB%20%E1%84%8B%E1%85%A1%E1%86%AF%E1%84%80%E1%85%A9%E1%84%85%E1%85%B5%E1%84%8C%E1%85%B3%E1%86%B7%20%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4%20132af5dd1ca14d9fb3eb5135ef5054d8/Screen_Shot_2022-07-05_at_10.26.58_AM.png)
            
        - **알고리즘 기초 과제 문제를 푸는 도 중 알게 된 사실**
            - 자바에서 정수를 입력 받지 않는 순간까지 계속 입력을 받도록 설정을 하고 싶으면 while(sc.hasNextInt()) 방식을 사용해서 입력을 받도록 설정을 하면 된다.
    - **자료구조1**
        - **스택**
            - **스택 구현 코드 (직접 구현한 코드) → 백준 10828**
                
                ```java
                **import java.io.BufferedWriter;
                import java.io.IOException;
                import java.io.OutputStreamWriter;
                import java.util.Scanner;
                
                public class Main {
                    public static void main(String[] args) throws IOException {
                        Scanner sc = new Scanner(System.in);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                        int n = sc.nextInt();
                        int[] stack = new int[n];
                        int size = 0;
                        while (n-- > 0) {
                            String cmd = sc.next();
                            if (cmd.equals("push")) {
                                int num = Integer.parseInt(sc.next());
                                stack[size++] = num;
                            } else if (cmd.equals("top")) {
                                if (size == 0) {
                                    bw.write("-1\n");
                                } else {
                                    bw.write(stack[size - 1] + "\n");
                                }
                            } else if (cmd.equals("size")) {
                                bw.write(size + "\n");
                            } else if (cmd.equals("empty")) {
                                if (size == 0) {
                                    bw.write("1\n");
                                } else {
                                    bw.write("0\n");
                                }
                            } else if (cmd.equals("pop")) {
                                if (size == 0) {
                                    bw.write("-1\n");
                                } else {
                                    bw.write(stack[size - 1] + "\n");
                                    size -= 1;
                                }
                            }
                        }
                        bw.flush();
                    }
                }**
                ```
                
            - **스택 구현 코드 (라이브러리 사용한 코드) → 백준 10828**
                
                ```java
                **import java.util.*;
                import java.io.*;
                
                public class Main {
                    public static void main(String args[]) throws IOException {
                        Scanner sc = new Scanner(System.in);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                        int n = sc.nextInt();
                        Stack<Integer> stack = new Stack<Integer>();
                        for (int k=0; k<n; k++) {
                            String cmd = sc.next();
                            if (cmd.equals("push")) {
                                int num = Integer.parseInt(sc.next());
                                stack.push(num);
                            } else if (cmd.equals("top")) {
                                if (stack.empty()) {
                                    bw.write("-1\n");
                                } else {
                                    bw.write(stack.peek()+"\n");
                                }
                            } else if (cmd.equals("size")) {
                                bw.write(stack.size()+"\n");
                            } else if (cmd.equals("empty")) {
                                if (stack.empty()) {
                                    bw.write("1\n");
                                } else {
                                    bw.write("0\n");
                                }
                            } else if (cmd.equals("pop")) {
                                if (stack.empty()) {
                                    bw.write("-1\n");
                                } else {
                                    bw.write(stack.pop()+"\n");
                                }
                            }
                        }
                        bw.flush();
                    }
                }**
                ```
                
            - **단어 뒤집기 → 백준 9093**
                
                ```java
                
                ```
                
        - **큐와 덱**
        - **연습**
    - **수학1**
        - **다이나믹 프로그래밍1(어려웠던 문제 모음)**
            - 백준 11052번 카드 구매하기([https://www.acmicpc.net/problem/11052](https://www.acmicpc.net/problem/11052)) → dp문제(16194번([https://www.acmicpc.net/problem/16194](https://www.acmicpc.net/problem/16194))도 같이 보기)
            - 백준 15990번 1, 2, 3 더하기 5([https://www.acmicpc.net/problem/15990](https://www.acmicpc.net/problem/15990))
            - 백준 11053번: 가장 긴 증가하는 부분 수열(Longest Increasing Subsequence)([https://www.acmicpc.net/problem/11053](https://www.acmicpc.net/problem/11053))
            - 백준 1912번: 연속합([https://www.acmicpc.net/problem/1912](https://www.acmicpc.net/problem/1912))
            - 백준 1699번: 제곱수의 합([https://www.acmicpc.net/problem/1699](https://www.acmicpc.net/problem/1699)) → 이건 필수로 다시 풀기
            - 백준 2225번: 합분해([https://www.acmicpc.net/problem/2225](https://www.acmicpc.net/problem/2225)) → 이것도 필수로 다시 보기
            - 백준 13398번: 연속합 2([https://www.acmicpc.net/problem/13398](https://www.acmicpc.net/problem/13398)) → 다시 풀어보기
            - 백준 2133번: 타일 채우기([https://www.acmicpc.net/problem/2133](https://www.acmicpc.net/problem/2133)) → 이건 참고용으로만 쓰기 세로의 길이가 3인 경우이다.
            - 백준 17404번: RGB거리 2([https://www.acmicpc.net/problem/17404](https://www.acmicpc.net/problem/17404)) → 다시 풀기
            
        - **풀었지만 좀 오래 걸렸던 다이나믹 프로그래밍 문제들**
            - **백준 10844번: 쉬운 계단 수(**[https://www.acmicpc.net/problem/10844](https://www.acmicpc.net/problem/10844)**)**
            - 백준 1932번: 정수 삼각형([https://www.acmicpc.net/problem/1932](https://www.acmicpc.net/problem/1932))
        - 동물원 도전 버젼에 대한 코드 답. → 시간 복잡도 때문에 O(N)에 맞추기 위해서 d[i]의 합을 나타낸 s[i]배열을 새로 이용했다.
            
            ```java
            **import java.util.*;
            public class Main {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    int[] d = new int[n+1];
                    int[] s = new int[n+1];
                    d[0] = 1;
                    s[0] = 1;
                    d[1] = 2;
                    s[1] = d[0] + d[1];
                    for (int i=2; i<=n; i++) {
                        d[i] = d[i-1] + 2*s[i-2];
                        s[i] = s[i-1] + d[i];
                        d[i] = d[i] % 9901;
                        s[i] = s[i] % 9901;
                    }
                    System.out.println(s[n]);
                }
            }**
            ```
            
- **알고리즘 기초 2/2**
    - 브루트 포스
        - 백준 1107번 리모컨: [https://www.acmicpc.net/problem/1107](https://www.acmicpc.net/problem/1107) → 못 품
    - **백 트래킹**
        - 백준 15663번 N과 M (9): [https://www.acmicpc.net/problem/15663](https://www.acmicpc.net/problem/15663)
        → 중복 제거를 어떻게 해야할지 몰라서 참고 했는데 코드가 매우 어렵다.
            - **코드 내용이 어려웠다.**
                
                ```java
                **import java.util.*;
                import java.io.*;
                
                class Result implements Comparable<Result> {
                
                    Integer[] a;
                
                    Result(ArrayList<Integer> a) {
                        this.a = a.toArray(new Integer[a.size()]);
                    }
                
                    @Override
                    public boolean equals(Object obj) {
                        if (obj instanceof Result) {
                            Result that = (Result) obj;
                            int n = this.a.length;
                            for (int i = 0; i < n; ++i)
                                if (this.a[i] != that.a[i])
                                    return false;
                            return true;
                        } else
                            return false;
                    }
                
                    int get(int idx) {
                        return (int)this.a[idx];
                    }
                
                    public int compareTo(Result that) {
                        int n = this.a.length;
                        for (int i = 0; i < n; ++i) {
                            if (this.a[i] == that.a[i])
                                continue;
                            if (this.a[i] < that.a[i])
                                return -1;
                            if (this.a[i] > that.a[i])
                                return 1;
                        }
                        return 0;
                    }
                }
                
                public class Main {
                
                    static int[] arr = new int[9];
                    static int[] input = new int[9];
                    static boolean[] check = new boolean[9];
                    static ArrayList<Result> d = new ArrayList<Result>();
                    public static void seq(int idx, int n, int m) {
                        if (idx >= m) {
                            ArrayList<Integer> temp = new ArrayList<Integer>();
                            for (int i = 0; i < m; ++i)
                                temp.add(input[arr[i]]);
                            d.add(new Result(temp));
                            return;
                        }
                        for (int i = 0; i < n; ++i) {
                            if (check[i] == false) {
                                check[i] = true;
                                arr[idx] = i;
                                seq(idx + 1, n, m);
                                check[i] = false;
                            }
                        }
                    }
                
                    public static void main(String args[]) throws IOException {
                
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(st.nextToken());
                        int m = Integer.parseInt(st.nextToken());
                        st = new StringTokenizer(br.readLine());
                        for (int i = 0; i < n; ++i)
                            input[i] = Integer.parseInt(st.nextToken());
                        Arrays.sort(input, 0, n);
                        seq(0, n, m);
                        Collections.sort(d);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < d.size(); ++i) {
                            if (i == 0 || !d.get(i).equals(d.get(i - 1))) {
                                for (int j = 0; j < m; ++j) {
                                    sb.append(d.get(i).get(j));
                                    if (j != m - 1);
                                        sb.append(" ");
                                }
                                sb.append("\n");
                            }
                        }
                        bw.write(sb + "\n");
                        bw.flush();
                    }
                }**
                ```
                
        - 백준 15664번 N과 M (10): [https://www.acmicpc.net/problem/15664](https://www.acmicpc.net/problem/15664)
        
    
        | 1 | 2 |
        | --- | --- |
        | 5 | 43 |
        | 7 | 6 |