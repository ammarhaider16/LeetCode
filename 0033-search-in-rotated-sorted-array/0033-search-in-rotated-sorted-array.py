class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums)-1

        while(start<=end):
            middle = (start+end)/2
            startVal = nums[start]
            middleVal = nums[middle]
            endVal = nums[end]

            if (target == startVal):
                return start
            if (target == middleVal):
                return middle
            if (target == endVal):
                return end

            if (middleVal>endVal):
                if (target>startVal and target<middleVal):
                    end = middle - 1
                else:
                    start = middle + 1
            elif (middleVal<startVal):
                if (target>middleVal and target<endVal):
                    start = middle + 1
                else:
                    end = middle - 1
            else:
                if (target>middleVal):
                    start = middle + 1
                else:
                    end = middle - 1
        return -1
            


