class Solution:
    def rob(self, nums:int) -> int:
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums[0], nums[1])
        n = len(nums)
        dp = [0] * n
        dp[n-1] = nums[n-1]
        dp[n-2] = nums[n-2]
        for i in range(n-3, -1, -1): 
            max_after = 0
            for j in range(i+2, n):
                if dp[j] > max_after:
                    max_after = dp[j]
                dp[i] = nums[i] + max_after 
        return max(dp)

    