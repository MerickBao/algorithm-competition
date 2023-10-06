package Atcoder.ABC318;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/18 21:52
 */

import java.io.*;
import java.util.*;

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
        int d = in.nextInt();
        long p = in.nextLong();
        long[] f = new long[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            f[i] = in.nextLong();
            ans += f[i];
        }
        Arrays.sort(f);
        for (int i = n - 1; i >= 0;) {
            long now = 0;
            int cnt = 0;
            while (cnt < d && i >= 0) {
                now += f[i];
                i--;
                cnt++;
            }
            if (now >= p) {
                ans = ans - now + p;
            }
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
