import java.io.*;
import java.util.*;

class Result implements Comparable<Result> {

    Integer[] a;
    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }

    public int get(int idx) {
        return (int)this.a[idx];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Result) {
            Result that = (Result)obj;
            int n = this.a.length;
            for (int i = 0; i < n; ++i)
                if (this.a[i].intValue() != that.a[i].intValue())
                    return false;
            return true;
        } else
            return false;
    }

    public int compareTo(Result that) {
        int n = this.a.length;
        for (int i = 0; i < n; ++i) {
            if (this.a[i] == that.a[i])
                continue;
            if (this.a[i] < that.a[i])
                return -1;
            if (this.a[i] > that.a[i])
                return 1;
        }
        return 0;
    }
}

public class Main {

    static int[] input = new int[9];
    static int[] arr = new int[9];
    static ArrayList<Result> d = new ArrayList<>();

    public static void seq(int idx, int start, int n, int m) {
        if (idx >= m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; ++i)
                temp.add(input[arr[i]]);
            d.add(new Result(temp));
            return;
        }

        for (int i = start; i < n; ++i) {
            arr[idx] = i;
            seq(idx + 1, i, n, m);
            arr[idx] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            input[i] = Integer.parseInt(st.nextToken());
        seq(0, 0, n, m);
        Collections.sort(d);
        for (int i = 0; i < d.size(); ++i) {
            if (i == 0 || !d.get(i).equals(d.get(i - 1))) {
                for (int j = 0; j < m; ++j) {
                    sb.append(d.get(i).get(j));
                    if (j != m - 1)
                        sb.append(" ");
                }
                sb.append("\n");;
            }
        }
        bw.write(sb + "\n");
        bw.flush();
    }
}
