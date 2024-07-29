class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currProfit = prices[i] - prices[start];
            maxProfit = Math.max(maxProfit, currProfit);
            if (currProfit < 0)
                start = i;
        }
        return maxProfit;
    }
}