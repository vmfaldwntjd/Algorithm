import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.')
                break;
            boolean flag = true;
            for (int i = 0; i < input.toCharArray().length; ++i) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[')
                    stack.push(input.charAt(i));
                else if (input.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (input.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                stack.clear();
                flag = false;
            }
            if (flag) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}