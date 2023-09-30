package DP;

import java.util.Arrays;

public class FibonacciSeries {

    public int fibRecursive(int n) {
        if(n<=1) return n;

        return fibRecursive(n-2) + fibRecursive(n-1);
    }

    public int fibMemoization(int n, int[] dp) {
        if(n<=1) return n;

        //not exist
        if(dp[n]==-1)
            dp[n] = (fibMemoization(n-2, dp) + fibMemoization(n-1, dp))%1000000007;

        return dp[n];
    }

    public int fibTabulation(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        //TC - O(N), SC - O(N)
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public int nthFibonacci(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return fibMemoization(n, dp);
    }
}
