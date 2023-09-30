package DP;

public class ClimbingStairs {

    public int climbingStairsRecursive(int n) {
        if(n<=1) return 1;

        return climbingStairsRecursive(n-1) + climbingStairsRecursive(n-2);
    }

    public int climbingStairsMemoization(int n, int[] dp) {
        if(n<=1) return 1;

        if(dp[n] ==-1)
            dp[n] = climbingStairsMemoization(n-1, dp) + climbingStairsMemoization(n-2, dp);

        return dp[n];
    }


    public int climbingStairsTabulation(int n, int[] dp) {
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
