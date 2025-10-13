class Solution:
    def coinChange(self, coins: List[List[int]], amount: int) -> int:
        dp = [float('inf')] * (amount + 1) 
        dp[0] = 0 
        for i in range(1, amount+1):
            min_combination = float('inf')
            for coin in coins:
                if (i-coin) >= 0 and dp[i-coin] < min_combination:
                    min_combination = dp[i-coin]
            if min_combination < float('inf'):
                dp[i] = 1 + min_combination 
        return dp[amount] if dp[amount] < float('inf') else -1