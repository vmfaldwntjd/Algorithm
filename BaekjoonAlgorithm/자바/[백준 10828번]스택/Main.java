import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[] stack = new int[n];
        int size = 0;

        while (n-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                stack[size++] = sc.nextInt();
            } else if (cmd.equals("pop")) {
                if (size == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack[size - 1] + "\n");
                    size--;
                }
            } else if (cmd.equals("size")) {
                bw.write(size + "\n");
            } else if (cmd.equals("empty")) {
                if (size == 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                if (size == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(stack[size - 1] + "\n");
                }
            }
        }
        bw.flush();
    }
}
