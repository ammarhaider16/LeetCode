class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        counts = [0]*len(nums)
        aux = []
        for i in range(len(nums)):
            aux.append((nums[i], i))
        counts = mergeSort(aux, 0, len(nums)-1, counts)
        return counts
        

def mergeSort(aux, start, end, counts):
    if (start>=end):
        return counts
    
    middle = (start+end)//2
    mergeSort(aux, start, middle, counts)
    mergeSort(aux, middle+1, end, counts)

    merged, counts = merge(aux, start, middle, middle+1, end, counts)
    mergedIndex = 0
    for i in range(start,end+1):
        aux[i] = merged[mergedIndex]
        mergedIndex+=1

    return counts

def merge(aux, leftStart, leftEnd, rightStart, rightEnd, counts):

    merged = []

    rightAddedCount = 0
    left = leftStart
    right = rightStart

    while (left<=leftEnd and right<=rightEnd):
        leftVal = aux[left][0]
        rightVal = aux[right][0]

        if (leftVal<=rightVal):
            merged.append(aux[left])
            counts[aux[left][1]] += rightAddedCount
            left+=1
        else:
            merged.append(aux[right])
            rightAddedCount+=1
            right+=1
    
    while (left<=leftEnd):
        merged.append(aux[left])
        counts[aux[left][1]] += rightAddedCount
        left+=1

    while (right<=rightEnd):
        merged.append(aux[right])
        rightAddedCount+=1
        right+=1

    return merged, counts
