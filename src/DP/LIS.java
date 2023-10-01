package DP;

public class LIS {

    int ans = 1;
    public int LISRecursive(int[] arr, int n) {

        //last Index Element
        if(n==0)
            return 1;

        int lis = 1;
        for(int i=0;i<n;i++) {
            if(arr[i] < arr[n]) {
               lis = Math.max(lis, LISRecursive(arr, i) + 1);
            }
        }

        //to consider the index values which are greater than current value
        LISRecursive(arr, n-1);
        ans = Math.max(ans, lis);
        return lis;
    }

    public int LISMemoization(int[] arr, int n, int[] dp) {

        //last Index Element
        if(n==0)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        int lis = 1;
        for(int i=0;i<n;i++) {
            if(arr[i] < arr[n]) {
                lis = Math.max(lis, LISMemoization(arr, i, dp) + 1);
            }
        }

        //to consider the index values which are greater than current value
        LISMemoization(arr, n-1, dp);
        ans = Math.max(ans, lis);
        dp[n] = lis;
        return dp[n];
    }

    public void LISTabulation(int[] arr, int n, int[] dp) {
        dp[0] = 1;
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
    }

}
