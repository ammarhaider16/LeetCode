class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        lookup = [0] * (len(nums) - 1)
        for n in nums:
            if lookup[n-1] == 0:
                lookup[n-1] = 1
            else:
                return n
