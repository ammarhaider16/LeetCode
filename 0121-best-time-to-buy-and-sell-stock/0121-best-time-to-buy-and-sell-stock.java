class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = 10000;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit)
                maxProfit = profit;

            if (prices[i] < minPrice)
                minPrice = prices[i];
        }
        return maxProfit;
    }
}