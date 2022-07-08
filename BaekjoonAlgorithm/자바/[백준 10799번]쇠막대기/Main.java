import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (i - stack.pop() == 1) {
                    result += stack.size();
                } else {
                    ++result;
                }
            }
        }
        System.out.println(result);
    }
}
