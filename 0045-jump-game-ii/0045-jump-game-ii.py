class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float('inf')] * n
        dp[n-1] = 0
        for i in range(n-2, -1, -1):
            min_after = float('inf')
            max_jump_size = min(n-1-i, nums[i]) + 1  # prevent over indexing
            for jump in range(1, max_jump_size): 
                if dp[i+jump] < min_after:
                    min_after = dp[i+jump]
            if min_after < float('inf'):
                dp[i] = 1 + min_after
        return dp[0]