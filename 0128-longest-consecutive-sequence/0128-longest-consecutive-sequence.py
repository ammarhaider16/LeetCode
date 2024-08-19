class Solution(object):

    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSeq = 0
        numSet = set(nums)

        for num in nums:
            if (num-1 not in numSet):
                thisSeq = 1
                while (num+thisSeq in numSet):
                    thisSeq+=1
                maxSeq=max(thisSeq, maxSeq)

        return maxSeq

        