package DP;

import java.util.Arrays;

public class LCS {

    public int LCSRecursive(String t1, int n, String t2, int m) {

        //if anyone of the string exhausted
        if(n<0 || m<0)
            return 0;

        //if char are not equal
        if(t1.charAt(n) != t2.charAt(m)) {
            return Math.max(LCSRecursive(t1, n-1, t2, m) , LCSRecursive(t1, n, t2, m-1));
        }

        return LCSRecursive(t1, n-1, t2, m-1) + 1;
    }

    public int LCSMemoization(String t1, int n, String t2, int m, int[][] dp) {

        //if anyone of the string exhausted
        if(n<0 || m<0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        //if char are not equal
        if(t1.charAt(n) != t2.charAt(m)) {
            dp[n][m] =  Math.max(LCSMemoization(t1, n-1, t2, m, dp) , LCSMemoization(t1, n, t2, m-1, dp));
        } else  {
            dp[n][m] =   LCSMemoization(t1, n-1, t2, m-1, dp) + 1;
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return LCSMemoization(text1, n-1, text2, m-1, dp);
    }

    public int LCSTabulation(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;

                else if(t1.charAt(i-1) != t2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                else
                    dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
        return dp[n][m];
    }
}
