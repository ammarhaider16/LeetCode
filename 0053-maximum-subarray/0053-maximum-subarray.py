class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        end = len(nums) - 1
        return maxSubArrayHelper(nums, 0, end)
        
        
def maxSubArrayHelper(nums, start, end):
    if (start == end):
        return nums[start]
    middle = (start + end) // 2
    maxLeftSum = maxSubArrayHelper(nums, start, middle)
    maxRightSum = maxSubArrayHelper(nums, middle+1, end)

    
    highestLeftSumFromCenter = float('-inf')
    currentSum = 0
    leftPointer = middle
    while (leftPointer>=start):
        currentSum+=nums[leftPointer]
        if (currentSum>highestLeftSumFromCenter):
            highestLeftSumFromCenter = currentSum
        leftPointer-=1

    highestRightSumFromCenter = float('-inf')
    currentSum = 0
    rightPointer = middle+1
    while (rightPointer<=end):
        currentSum+=nums[rightPointer]
        if (currentSum>highestRightSumFromCenter):
            highestRightSumFromCenter = currentSum
        rightPointer+=1

    maxCenterSum = highestLeftSumFromCenter + highestRightSumFromCenter

    return max(maxCenterSum, max(maxLeftSum, maxRightSum))






