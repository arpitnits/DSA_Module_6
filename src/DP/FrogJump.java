package DP;

public class FrogJump {

    int ans = Integer.MAX_VALUE;
    public void energyLostRecursiveLeftToRight(int n, int currentHeightIndex, int energyLost, int lastIndex, int[] heights) {

        if(currentHeightIndex>=n)
            return;

        int heightDiff = 0;
        if(lastIndex!=-1)
           heightDiff = Math.abs(heights[currentHeightIndex] - heights[lastIndex]);
        energyLost = energyLost + heightDiff;

        if(currentHeightIndex == n-1) {
            ans = Math.min(ans, energyLost);
            return;
        }

        energyLostRecursiveLeftToRight(n, currentHeightIndex+1, energyLost, currentHeightIndex, heights);
        energyLostRecursiveLeftToRight(n, currentHeightIndex+2, energyLost, currentHeightIndex, heights);
    }

    public int energyLostRecursive(int n, int currentHeightIndex, int[] heights) {
        if(currentHeightIndex==0)
            return 0;

        if(currentHeightIndex==1) {
            return Math.abs(heights[1] - heights[0]);
        }

        int oneStep = energyLostRecursive(n , currentHeightIndex-1, heights);
        int twoStep = energyLostRecursive(n , currentHeightIndex-2, heights);

        return Math.min(
                oneStep + Math.abs(heights[currentHeightIndex] - heights[currentHeightIndex-1]),
                twoStep + Math.abs(heights[currentHeightIndex] - heights[currentHeightIndex-2])
        );
    }

    public int energyLostMemoization(int n, int currentHeightIndex, int[] heights, int[] dp) {
        if(currentHeightIndex==0)
            return 0;

        if(currentHeightIndex==1) {
            return Math.abs(heights[1] - heights[0]);
        }

        if(dp[currentHeightIndex]!= -1)
            return dp[currentHeightIndex];

        int oneStep = energyLostMemoization(n , currentHeightIndex-1, heights, dp);
        int twoStep = energyLostMemoization(n , currentHeightIndex-2, heights, dp);

        dp[currentHeightIndex] = Math.min(
                oneStep + Math.abs(heights[currentHeightIndex] - heights[currentHeightIndex-1]),
                twoStep + Math.abs(heights[currentHeightIndex] - heights[currentHeightIndex-2])
        );

        return dp[currentHeightIndex];
    }

    public int energyLostTabulation(int n, int[] heights, int[] dp) {
        dp[0] = 0;
        if(n==1)
            return 0;

        dp[1] = Math.abs(heights[1] - heights[0]);

        for(int i=2;i<n;i++) {
            dp[i] = Math.min(
                    dp[i-1] + Math.abs(heights[i] - heights[i-1]),
                    dp[i-2] + Math.abs(heights[i] - heights[i-2])
            );
        }
        return dp[n-1];
    }
}
