package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumPathSum {

    public int minPathRecursive(int[][] grid, int m, int n) {

        if(m<0 || n<0)
            return Integer.MAX_VALUE;

        if(m==0 && n==0)
            return grid[0][0];

        return grid[m][n] +
                Math.min(
                    minPathRecursive(grid, m-1, n),
                        minPathRecursive(grid, m, n-1));
    }

    public int minPathMemoization(int[][] grid, int m, int n, int[][] dp) {

        if(m<0 || n<0)
            return Integer.MAX_VALUE;

        if(m==0 && n==0)
            return grid[0][0];

        if(dp[m][n] != -1)
            return dp[m][n];

        dp[m][n] = grid[m][n] +
                Math.min(
                        minPathMemoization(grid, m-1, n, dp),
                        minPathMemoization(grid, m, n-1, dp));

        return dp[m][n];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] rows : dp)
            Arrays.fill(rows, -1);
        return minPathMemoization(grid, m-1, n-1, dp);
    }

    public int minPathTabulation(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for(int[] rows : cost)
            Arrays.fill(rows, -1);
        cost[0][0] = grid[0][0];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0)
                    continue;
                else if(i==0)
                    cost[i][j] = grid[i][j] + cost[0][j-1];
                else if(j==0)
                    cost[i][j] = grid[i][j] + cost[i-1][0];
                else
                    cost[i][j] = grid[i][j] + Math.min(cost[i-1][j], cost[i][j-1]);
            }
        }
        return cost[m-1][n-1];
    }

}
