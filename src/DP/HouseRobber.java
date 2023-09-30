package DP;

public class HouseRobber {

    public int robRecursive(int[] nums, int i, int n) {

        //Base Condition
        if(i>n-1)
            return 0;

        int include = robRecursive(nums, i+2, n) + nums[i];
        int exclude = robRecursive(nums, i+1, n);

        return Math.max(include, exclude);
    }

    public int robMemoization(int[] nums, int i, int n, int[] dp) {

        //Base Condition
        if(i<0)
            return 0;

        if(dp[i]!=-1)
            return dp[i];

        int include = robMemoization(nums, i-2, n, dp) + nums[i];
        int exclude = robMemoization(nums, i-1, n, dp);

        dp[i] = Math.max(include, exclude);
        return dp[i];
    }

    public int robTabulation(int[] nums, int n, int[] dp) {

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2;i<n;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }
}

