import java.util.*;

public class Main {

    public static boolean isValid(String s, Stack<Character> stack) {
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            String s = sc.next();
            Stack<Character> stack = new Stack<Character>();

            if (isValid(s, stack)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
