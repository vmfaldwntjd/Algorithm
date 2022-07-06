import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[100001];
        char[] result = new char[200001];
        int n;
        int pivot = 0, count = 0;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; ++i) {
            if (pivot < arr[i]) {
                while (pivot < arr[i]) {
                    stack.push(pivot + 1);
                    result[count++] = '+';
                    pivot++;
                }
                stack.pop();
                result[count++] = '-';
            } else {
                if (stack.isEmpty() || stack.peek() < arr[i]) {
                    System.out.println("NO");
                    return;
                } else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                        stack.pop();
                        result[count++] = '-';
                    }
                }
            }
        }

        for (int i = 0; i < count; ++i) {
            System.out.println(result[i]);
        }
    }
}
