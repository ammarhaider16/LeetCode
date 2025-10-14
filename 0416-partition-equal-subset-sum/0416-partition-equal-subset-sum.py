class Solution:
    def canPartition(self, nums):
        n_2 = sum(nums)
        if n_2 % 2 != 0:
            return False
        m, n = len(nums), n_2 // 2 
        dp = [[False]*n for _ in range(m)]
        for j in range(n):
            dp[0][j] = True if nums[0] == (j+1) else False
        for i in range(1, m):
            for j in range(n):
                use_index = (j - nums[i])
                dp[i][j] = True if (use_index >= 0 and dp[i-1][use_index]) or (dp[i-1][j]) or (use_index == -1) else False
        return dp[m-1][n-1]   # Correct, now optimizing
