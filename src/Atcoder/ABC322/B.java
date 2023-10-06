package Atcoder.ABC322;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/30 19:01
 */

import java.io.*;
import java.util.*;
import java.math.*;

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
        int m = in.nextInt();
        String a = in.next();
        String b = in.next();
        boolean l = b.substring(0, n).equals(a);
        boolean r = b.substring(m - n).equals(a);
        if (l && r) {
            out.println(0);
        } else if (l) {
            out.println(1);
        } else if (r) {
            out.println(2);
        } else {
            out.println(3);
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
