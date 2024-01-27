package Atcoder.ABC338;

import java.io.*;
import java.util.*;
import java.math.*;

public class C {
    public static Reader in;
    public static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        in = new Reader();
        solve();
        out.close();
    }

    static void solve(){
        int n = in.nextInt();
        long[] q = new long[n];
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int ans = 0;
        f : for (int i = 0; i <= 1000000; i++) {
            if (i >= 1) {
                for (int j = 0; j < n; j++) {
                    q[j] -= a[j];
                    if (q[j] < 0) {
                        break f;
                    }
                }
            }
            int l = 0, r = 1000000;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (check(q, b, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (!check(q, b, l)) l--;
            ans = Math.max(ans, i + l);
        }
        out.println(ans);
    }

    static boolean check(long[] q, long[] b, int mid) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] - b[i] * mid < 0) {
                return false;
            }
        }
        return true;
    }

    static class Reader {
        private BufferedReader br;
        private StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}
