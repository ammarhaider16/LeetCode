class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        globalMax = nums[n-1]

        for i in range(n-2,-1,-1):
            compare = nums[i]+nums[i+1]
            if (nums[i] < compare):
                nums[i] = compare
            globalMax = max(globalMax, nums[i])

        return globalMax