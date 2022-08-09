문제 링크: https://code.plus/lecture/497
- - -
## 고찰 및 해결 과정
### 방법 1
- 재귀 호출의 방식을 통해서 문제를 해결하는 방법이다.  
- 코드 내용  
```JAVA
import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int[] t = new int[17];
    static int[] p = new int[17];
    public static void revenue(int n, int day, int sum) {
        if (day == n + 1) { //day가 n + 1이 되면 퇴사하는 날이므로 현재 수익 result와 계산된 수익 sum과 비교하여 최대 수익을 추출한다.  
            if (result < sum)
                result = sum;
            return;
        }
        if (day > n + 1) //n + 1이 넘어가면 재귀 호출을 종료한다.  
            return;
        revenue(n, day + t[day], sum + p[day]); //상담가능한 날짜인 경우 호출 방식이다. 
        revenue(n, day + 1, sum); //상담이 불가능한 날짜인 경우는 기존 수익인 sum은 놔두고 하루를 추가하며 다시 호출한다.  
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        revenue(n, 1, 0);
        bw.write(result + "\n");
        bw.flush();
    }
}
```
### 방법 2
- 다이나믹 프로그래밍 문제로도 해결할 수 있는 방법이 있다.  
- 테이블을 거꾸로 스캔하면서 확인하는 방법이 존재.  
- 코드 내용
```JAVA
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] d = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = n; i >= 1; --i) {
            if (i + t[i] <= n + 1) {
                d[i] = Math.max(p[i] + d[i + t[i]], result);
                result = d[i];
            } else {
                d[i] = result;
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}
```
