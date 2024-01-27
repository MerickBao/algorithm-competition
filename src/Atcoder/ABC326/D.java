package Atcoder.ABC326;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/28 19:55
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class D {
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
        String x = in.nextLine();
        String y = in.nextLine();
        char[][] a = new char[n][n];
        if (x.charAt(0) != y.charAt(0)) {
            out.println("No");
            return;
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(a[i], '.');
        }
        dfs(a, x, y, 0, 0);
        if (ans == null) {
            out.println("No");
        } else {
            out.println("Yes");
            for (int i = 0; i < a.length; i++) {
                out.println(ans[i]);
            }
        }
    }

    static char[][] ans = null;
    static int[] cntX = new int[5];
    static int[] cntY = new int[5];

    static char[] xx = {'.', '.', '.', '.', '.' };
    static char[] yy = {'.', '.', '.', '.', '.' };

    static int[] fx = new int[5];
    static int[] fy = new int[5];

    static void dfs(char[][] a, String x, String y, int i, int j) {
        if (i == a.length - 1 && j == a.length - 1) {
            print(a);
            if (check(a, x, y)) {
                ans = new char[a.length][a[0].length];
                for (int idx = 0; idx < a.length; idx++) {
                    ans[idx] = a[idx].clone();
                }
            }
            return;
        }
        if (ans != null) return;

        for (char c = 'A'; c <= 'C'; c++) {
            if (xx[i] == '.' && (c != x.charAt(i))) {continue;
            }
            if (yy[j] == '.' && (c != y.charAt(j))) {continue;
            }
            if (cntX[i] + 1 > 3) continue;
            if (cntY[j] + 1 > 3) continue;
            if (((fx[i] >> (c - 'A')) & 1) == 1) continue;
            if (((fy[j] >> (c - 'A')) & 1) == 1) continue;
            fx[i] |= 1 << (c - 'A');
            fy[j] |= 1 << (c - 'A');
            a[i][j] = c;
            cntX[i]++;
            cntY[j]++;
            if (xx[i] == '.') xx[i] = c;
            if (yy[i] == '.') yy[j] = c;
            if (j == a.length - 1) {
                dfs(a, x, y, i + 1, 0);
            } else {
                dfs(a, x, y, i, j + 1);
            }
            if (xx[i] == c) xx[i] = '.';
            if (yy[j] == c) yy[j] = '.';
            cntX[i]--;
            cntY[j]--;
            a[i][j] = '.';
            fx[i] ^= 1 << (c - 'A');
            fy[j] ^= 1 << (c - 'A');
        }

        if (j == a.length - 1) {
            dfs(a, x, y, i + 1, 0);
        } else {
            dfs(a, x, y, i, j + 1);
        }
    }

    static boolean check(char[][] a, String x, String y) {
        char[] tx = new char[a.length];
        char[] ty = new char[a.length];
        Arrays.fill(tx, '.');
        Arrays.fill(ty, '.');
        int[] cx = new int[a.length];
        int[] cy = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != '.') {
                    if (tx[i] == '.') {
                        if (a[i][j] != x.charAt(i)) return false;
                        tx[i] = a[i][j];
                    }
                    if (ty[j] == '.') {
                        if (a[i][j] != y.charAt(j)) return false;
                        ty[j] = a[i][j];
                    }
                    if (((cx[i] >> (a[i][j] - 'A')) & 1) == 1) return false;
                    if (((cy[j] >> (a[i][j] - 'A')) & 1) == 1) return false;
                    cx[i] |= 1 << (a[i][j] - 'A');
                    cy[j] |= 1 << (a[i][j] - 'A');
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (Integer.bitCount(cx[i]) != 3) return false;
            if (Integer.bitCount(cy[i]) != 3) return false;
        }
        return true;
    }

    static void print(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            out.println(Arrays.toString(a[i]));
        }
        out.println();
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
