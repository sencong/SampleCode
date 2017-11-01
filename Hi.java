package test;

import java.util.LinkedList;
import java.util.List;

public class Hi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(minCut("aab"));
		int[] a = {1,2,3};
		
	}
	public static int minCut(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >= 0; --i) {
            for (int j = i+1; j < n; ++j) {
                dp[i][j]=(s.charAt(i)==s.charAt(j))&&(j<i+2||dp[i+1][j-1]);
            }
        }
        int[] f = new int[n+1];
        f[0] = 0;
        for (int j = 1; j <= n; j++) {
            f[j] = j;
            for (int i = 0; i < j; i++) {
                if (dp[i][j - 1]) {
                    f[j] = Math.min(f[j], f[i] + 1);
                }
            }
        }

        return f[n] - 1;
    }

}
