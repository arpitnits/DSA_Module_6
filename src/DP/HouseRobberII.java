package DP;

public class HouseRobberII {

    public int robTabulation(int[] nums, int strIndex, int n, int[] dp) {

        dp[strIndex] = nums[strIndex];

        for(int i=strIndex+1;i<n;i++) {

            //for dp[1]
            if(i-2<0)
                dp[i] = Math.max(dp[i-1], nums[i]);
            else
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }
}
