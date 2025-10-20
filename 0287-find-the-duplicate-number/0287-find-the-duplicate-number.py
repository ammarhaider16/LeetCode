class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for n in nums:
            key = abs(n)
            if nums[key-1] > 0:
                nums[key-1] = -nums[key-1]
            else:
                return key
