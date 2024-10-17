import heapq

class Solution(object):
    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        heapq.heapify(nums)
        return [heapq.heappop(nums) for _ in range(len(nums))]
        

