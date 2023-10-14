package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

    public int minCoinRecursive(int[] coins, int n, int totalVal) {

        //Base Condition - Not possible
        if(n<0 || totalVal<0)
            return -1;

        //Base Condition - Possible
        if(totalVal==0)
            return 0;

        //take
        int take = minCoinRecursive(coins, n, totalVal-coins[n]);

        //don't take
        int notTake = minCoinRecursive(coins, n-1, totalVal);

        if(take==-1 && notTake==-1) return -1;
        else if(take==-1) return notTake;
        else if(notTake==-1) return take+1;

        return Math.min(take+1, notTake);
    }

    public int minCoinMemoization(int[] coins, int n, int totalVal, int[][] dp) {

        //Base Condition - Not possible
        if(n<0 || totalVal<0)
            return -1;

        //Base Condition - Possible
        if(totalVal==0)
            return 0;

        if(dp[n][totalVal]!=-2)
            return dp[n][totalVal];
        //take
        int take = minCoinMemoization(coins, n, totalVal-coins[n], dp);

        //don't take
        int notTake = minCoinMemoization(coins, n-1, totalVal, dp);

        if(take==-1 && notTake==-1) dp[n][totalVal] = -1;
        else if(take==-1) dp[n][totalVal] = notTake;
        else if(notTake==-1) dp[n][totalVal] = take+1;
        else dp[n][totalVal] = Math.min(take+1, notTake);
        return dp[n][totalVal];
    }

    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] rows : dp)
            Arrays.fill(rows, -2);

        return minCoinMemoization(coins, n-1, amount, dp);
    }

    public int minCoinTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        int maxVal = amount+1;

        //no coins needed for amount =0;
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;

        //not possible, so updte with some maxVal
        for(int val=1;val<=amount;val++)
            dp[0][val] = maxVal;

        for(int i=1;i<=n;i++) {
            for(int val=1;val<=amount;val++) {

                //take possible
                if(coins[i-1] <= val) {
                    dp[i][val] = Math.min(dp[i-1][val], dp[i][val-coins[i-1]] + 1);
                } else {
                    //not Take
                    dp[i][val] = dp[i-1][val];
                }
            }
        }
        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }
}
