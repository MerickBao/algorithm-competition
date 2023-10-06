package Atcoder.ABC322;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/30 19:01
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
        int[][] a = new int[4][4], b = new int[4][4], c = new int[4][4];
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            String s = in.nextLine();
            for (int j = 0; j < 4; j++) {
                a[i][j] = s.charAt(j) == '#' ? 1 : 0;
                if (a[i][j] > 0) cnt++;
            }
        }
        for (int i = 0; i < 4; i++) {
            String s = in.nextLine();
            for (int j = 0; j < 4; j++) {
                b[i][j] = s.charAt(j) == '#' ? 2 : 0;
                if (b[i][j] > 0) cnt++;
            }
        }
        for (int i = 0; i < 4; i++) {
            String s = in.nextLine();
            for (int j = 0; j < 4; j++) {
                c[i][j] = s.charAt(j) == '#' ? 3 : 0;
                if (c[i][j] > 0) cnt++;
            }
        }
        if (cnt != 16) {
            out.println("No");
            return;
        }
        int[][] ta = new int[4][4], tb = new int[4][4], tc = new int[4][4];
        for (int i = 0; i < 4; i++) {
            int[][] now = X(a, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        ta[x][y] = now[x][y];
                    }
                }
            }
            now = X(b, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        tb[x][y] = now[x][y];
                    }
                }
            }
            now = X(c, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        tc[x][y] = now[x][y];
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = ta[i][j];
                b[i][j] = tb[i][j];
                c[i][j] = tc[i][j];
            }
        }
        int[][] tta = new int[4][4], ttb = new int[4][4], ttc = new int[4][4];
        for (int i = 0; i < 4; i++) {
            int[][] now = Y(a, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        tta[x][y] = now[x][y];
                    }
                }
            }
            now = Y(b, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        ttb[x][y] = now[x][y];
                    }
                }
            }
            now = Y(c, -i);
            if (now[0][0] != -1) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        ttc[x][y] = now[x][y];
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = tta[i][j];
                b[i][j] = ttb[i][j];
                c[i][j] = ttc[i][j];
            }
        }
        for (int x1 = 0; x1 < 4; x1++) {
            for (int y1 = 0; y1 < 4; y1++) {
                for (int z1 = 0; z1 < 4; z1++) {
                    int[][] aa = get(a, x1, y1, z1);
                    if (aa[0][0] == -1) continue;
                    for (int x2 = 0; x2 < 4; x2++) {
                        for (int y2 = 0; y2 < 4; y2++) {
                            for (int z2 = 0; z2 < 4; z2++) {
                                int[][] bb = get(b, x2, y2, z2);
                                if (bb[0][0] == -1) continue;
                                for (int x3 = 0; x3 < 4; x3++) {
                                    for (int y3 = 0; y3 < 4; y3++) {
                                        for (int z3 = 0; z3 < 4; z3++) {
                                            int[][] cc = get(c, x3, y3, z3);
                                            if (cc[0][0] == -1) continue;
                                            if (ok(aa, bb, cc)) {
                                                out.println("Yes");
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println("No");
    }

    static int[][] get(int[][] a, int x, int y, int z) {
        int[][] tmp = X(a, x);
        if (tmp[0][0] == -1) return tmp;
        tmp = Y(tmp, y);
        if (tmp[0][0] == -1) return tmp;
        for (int i = 0; i < z; i++) {
            rotate(tmp);
        }
        return tmp;
    }

    static boolean ok(int[][] a, int[][] b, int[][] c) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int cnt = 0;
                if (a[i][j] > 0) cnt++;
                if (b[i][j] > 0) cnt++;
                if (c[i][j] > 0) cnt++;
                if (cnt != 1) return false;
            }
        }
        return true;
    }

    static int[][] X(int[][] a, int t) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i][j] > 0) {
                    if (j + t < 4 && j + t >= 0) {
                        tmp[i][j + t] = a[i][j];
                    } else {
                        tmp[0][0] = -1;
                        return tmp;
                    }
                }
            }
        }
        return tmp;
    }

    static int[][] Y(int[][] a, int t) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i][j] > 0) {
                    if (i + t >= 0 && i + t < 4) {
                        tmp[i + t][j] = a[i][j];
                    } else {
                        tmp[0][0] = -1;
                        return tmp;
                    }
                }
            }
        }
        return tmp;
    }

    static int[][] Z(int[][] a, int t) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < t; i++) {
            rotate(tmp);
        }
        return tmp;
    }

    static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = t;
            }
        }
        // 左对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
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
