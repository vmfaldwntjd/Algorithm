import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) {
        int t;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(sc.next(), ",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a + b);
        }
    }
}
