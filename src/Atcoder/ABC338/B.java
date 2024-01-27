package Atcoder.ABC338;

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
        String s = in.nextLine();
        int[] cnt = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            max = Math.max(max, cnt[s.charAt(i) - 'a']);
        }
        for (int i = 0; i < 26; i++) {
            if (max == cnt[i]) {
                out.println((char) ('a' + i));
                return;
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
