package Atcoder.ABC326;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/28 19:55
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class A {
    public static Reader in;
    public static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        in = new Reader();
        solve();
        out.close();
    }

    static void solve(){
        int x = in.nextInt();
        int y = in.nextInt();
        if (x > y) {
            if (x - y <= 3) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        } else if (x < y) {
            if (y - x <= 2) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        } else {
            out.println("No");
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
