package DP;

public class Knapsack {

    public int knapsackRecursive(int W, int i, int[] wt, int[] val, int n) {
        //Base Condition
        if(W==0 || i==n)
            return 0;

        int take = 0;
        if(wt[i]<=W) {
            take = knapsackRecursive(W-wt[i], i+1, wt, val, n) + val[i];
        }

        int notTake = knapsackRecursive(W, i+1, wt, val, n);

        return Math.max(take, notTake);
    }

    public int knapsackMemoization(int W, int i, int[] wt, int[] val, int n, int[][] dp) {
        //Base Condition
        if(W==0 || i==n)
            return 0;

        if(dp[i][W]!=-1)
            return dp[i][W];

        int take = 0;
        if(wt[i]<=W) {
            take = knapsackMemoization(W-wt[i], i+1, wt, val, n, dp) + val[i];
        }

        int notTake = knapsackMemoization(W, i+1, wt, val, n, dp);

        dp[i][W] = Math.max(take, notTake);
        return dp[i][W];
    }

    public int knapsackTabulation(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];

        //O(n^2)
        //O(n^2)
        for(int i=0;i<=n;i++) {
            for (int w=0;w<=W;w++) {
                if(i==0 || w==0)
                    dp[i][w] = 0;

                //not take
                else if(wt[i-1] > w)
                    dp[i][w] = dp[i-1][w];

                //possible to take and not take
                else
                    dp[i][w] = Math.max(dp[i-1][w], val[i-1] + dp[i-1][w-wt[i-1]]);
            }
        }
        return dp[n][W];
    }
}
