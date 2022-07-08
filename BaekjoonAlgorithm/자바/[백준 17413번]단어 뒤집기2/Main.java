import java.util.*;
import java.io.*;

public class Main {

    public static void print(String s, Stack<Character> stack) throws IOException {
        boolean tag = false;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case ('<'):
                    tag = true;
                    while (!stack.isEmpty())
                        bw.write(stack.pop());
                    bw.write(ch);
                    break;
                case ('>'):
                    tag = false;
                    bw.write(ch);
                    break;
                default:
                    if (tag)
                        bw.write(ch);
                    else {
                        if (ch == ' ') {
                            while (!stack.isEmpty())
                                bw.write(stack.pop());
                            bw.write(" ");
                        }
                        else
                            stack.push(ch);
                    }
            }
        }
        while (!stack.isEmpty())
            bw.write(stack.pop());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        String s = sc.nextLine();

        print(s, stack);
    }
}
