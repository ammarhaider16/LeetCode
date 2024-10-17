from collections import Counter
import heapq

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        frequencies = Counter(nums)
        nums = [0]*len(frequencies)
        current = 0
        for item, frequency in frequencies.items():
            nums[current] = (-frequency, item)
            current+=1
        heapq.heapify(nums)
        toReturn = [0]*k
        current = 0
        while(k>0):
            toReturn[current] = heapq.heappop(nums)[1]
            current += 1
            k -= 1
        return toReturn