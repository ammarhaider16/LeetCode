class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k = 0
        e = len(nums)-1
        for i in range(0, e+1):
            if nums[i] == 0:
                nums[i], nums[k] = nums[k], nums[i]
                k+=1

        j = e
        for i in range(e, k-1,-1):
            if nums[i] == 2:
                nums[j], nums[i] = nums[i], nums[j]
                j -= 1

        