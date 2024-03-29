package Atcoder.ABC326;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/28 19:55
 */

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
        int m = in.nextInt() - 1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (a[mid] <= a[i] + m) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (a[l] > a[i] + m) {
                l--;
            }
            ans = Math.max(ans, l - i + 1);
        }
        out.println(ans);
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
