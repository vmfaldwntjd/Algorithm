import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String str = sc.nextLine() + "\n";

            for (int j = 0; j < str.length(); ++j) {
                if (str.charAt(j) != ' ' && str.charAt(j) != '\n') {
                    stack.push(str.charAt(j));
                }
                else {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                }
            }
            while (!stack.isEmpty()) {
                bw.write(stack.pop());
            }
            bw.flush();
        }
    }
}