package DP;

public class FrogJump2 {

    public int energyLostTabulation(int n, int[] heights, int k, int[] dp) {
        dp[0] = 0;
        if(n==1)
            return 0;

        dp[1] = Math.abs(heights[1] - heights[0]);

        for(int i=2;i<n;i++) {
            dp[i] = Integer.MAX_VALUE;
            //checking all previous K steps energyLost
            for(int j=i-1;j>=0;j--) {

                //only k steps
                if(i-j > k) break;

                dp[i] = Math.min(dp[i], dp[j] + Math.abs(heights[i] - heights[j]));
            }
        }
        return dp[n-1];
    }
}

