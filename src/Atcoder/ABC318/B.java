package Atcoder.ABC318;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/18 21:52
 */

import java.io.*;
import java.util.*;

public class B {
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
        int ans = 0;
        int[][] a = new int[110][110];
        for (int i = 0; i < n; i++) {
            int y1 = in.nextInt();
            int y2 = in.nextInt();
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    a[j][k]++;
                }
            }
        }
        for (int i = 0; i < 110; i++) {
            if (i + 1 < 110) {
                int prev = 0;
                for (int j = 0; j < 110; j++) {
                    if (a[i + 1][j] > 0 && a[i][j] > 0) {
                        prev++;
                    } else {
                        if (prev > 0) ans += prev - 1;
                        prev = 0;
                    }
                }
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
