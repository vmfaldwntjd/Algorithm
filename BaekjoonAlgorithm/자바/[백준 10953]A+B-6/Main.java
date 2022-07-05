import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int t;
        String s;
        int a, b;
        String[] p;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            s = sc.next();
            p = s.split(",");
            a = Integer.parseInt(p[0]);
            b = Integer.parseInt(p[1]);
            System.out.println(a + b);
        }
    }
}

