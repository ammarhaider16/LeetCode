class Solution:
    def canPartition(self, nums):
        n_2 = sum(nums)
        if n_2 % 2 != 0:
            return False
        m, n = len(nums), n_2 // 2 
        dp = [[False]*(n+1) for _ in range(m)]
        for i in range(m):
            dp[i][0] = True
        for j in range(1, n+1):
            dp[0][j] = True if nums[0] == j else False
        for i in range(1, m):
            for j in range(1, n+1):
                use_index = j - nums[i]
                dp[i][j] = True if (use_index >= 0 and dp[i-1][use_index]) or (dp[i-1][j]) else False
        return dp[m-1][n]

    