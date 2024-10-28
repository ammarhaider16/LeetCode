class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [0]*len(nums)
        dp[n-1] = nums[n-1]
        globalMax = dp[n-1]

        for i in range(n-2,-1,-1):
            dp[i] = max(nums[i], nums[i]+dp[i+1])
            globalMax = max(globalMax, dp[i])

        return globalMax



