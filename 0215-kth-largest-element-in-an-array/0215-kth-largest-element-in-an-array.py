import heapq


class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        heap = maxHeapify(nums)
        popped = 0
        while (k>0):
            popped = maxHeapPop(heap)
            k-=1
        return popped

def maxHeapify(arr):
        arr = [-x for x in arr]
        heapq.heapify(arr)
        return arr

def maxHeapPop(heap):
    return -heapq.heappop(heap)