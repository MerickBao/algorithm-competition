package Atcoder.ABC318;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/18 21:52
 */

import java.io.*;
import java.util.*;

public class D {
    public static Reader in;
    public static PrintWriter out;

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        in = new Reader();
        solve();
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        long[] dp = new long[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    for (int j = i + 1; j < n; j++) {
                        if ((mask & (1 << j)) == 0) {
                            dp[mask | (1 << i) | (1 << j)] = Math.max(dp[mask | (1 << i) | (1 << j)], dp[mask] + a[i][j]);
                        }
                    }
                }
            }
        }
        out.println(dp[(1 << n) - 1]);
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
