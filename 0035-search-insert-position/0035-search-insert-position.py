class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if (len(nums)==1):
            return 1 if target>nums[0] else 0

        start = 0
        end = len(nums)-1
        smallestGreaterIndex = len(nums)-1
        greaterFound = False

        while (start<=end):
            mid = (start+end)/2

            if (nums[mid] == target):
                return mid
            elif (nums[mid]>target):
                smallestGreaterIndex = mid
                end = mid - 1
                greaterFound = True
            else:
                start = mid + 1

        return smallestGreaterIndex if greaterFound else smallestGreaterIndex+1