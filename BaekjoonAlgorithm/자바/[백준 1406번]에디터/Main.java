import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (char ch : s.toCharArray()) {
            stack1.push(ch);
        }
        for (int i = 0; i < n; ++i) {
            String input = br.readLine();
            if (input.charAt(0) == 'P') {
                stack1.push(input.charAt(2));
            } else if (input.charAt(0) == 'L') {
                if (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else if (input.charAt(0) == 'D') {
                if (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else if (input.charAt(0) == 'B') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            bw.write(stack2.pop());
        }
        bw.flush();
    }
}
