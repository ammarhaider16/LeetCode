class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];

        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i] += cost[i];
            if (i < dp.length - 2)
                dp[i] += Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}