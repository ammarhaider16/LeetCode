class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float('inf')] * n
        dp[n-1] = 0
        for i in range(n-2, -1, -1):
            min_after = float('inf')
            upper_bound = min(n, i + 1 + nums[i])
            for jump in range(i+1, upper_bound): 
                if dp[jump] < min_after:
                    min_after = dp[jump]
            if min_after < float('inf'):
                dp[i] = 1 + min_after
        return dp[0]