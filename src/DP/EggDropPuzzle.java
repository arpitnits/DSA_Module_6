package DP;

import java.util.Arrays;

public class EggDropPuzzle {

    public static int eggDropRecursive(int n, int k) {

        if(k==1 || k==0)
            return k;

        //only one egg
        if(n==1)
            return k;

        int res = Integer.MAX_VALUE;
        for(int floor = 1; floor<=k; floor++) {
            int eggBreak = eggDropRecursive(n-1, floor-1);
            int notBreak = eggDropRecursive(n, k-floor);

            res = Math.min(res, Math.max(eggBreak, notBreak));
        }
        return res + 1;
    }
    public static int eggDropMemoization(int n, int k, int[][] dp) {

        if(k==1 || k==0)
            return k;

        //only one egg
        if(n==1)
            return k;

        if(dp[n][k]!=-1)
            return dp[n][k];

        int res = Integer.MAX_VALUE;
        for(int floor = 1; floor<=k; floor++) {
            int eggBreak = eggDropMemoization(n-1, floor-1, dp);
            int notBreak = eggDropMemoization(n, k-floor, dp);

            res = Math.min(res, Math.max(eggBreak, notBreak));
        }
        dp[n][k] = res + 1;
        return dp[n][k];
    }

    static int eggDrop(int n, int k)
    {
       int[][] dp = new int[n+1][k+1];
       for(int[] rows : dp)
           Arrays.fill(rows, -1);

       return eggDropMemoization(n, k, dp);
    }

    /**
     * dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][j-1], dp[i][k-j]))
     */
}
