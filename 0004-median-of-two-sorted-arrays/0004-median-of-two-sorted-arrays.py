class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        return medianOfTwoSorted(nums1, nums2)
    
def medianOfTwoSorted(A, B):
    
    n1, n2 = len(A), len(B)
    if (n1 > n2):
        return medianOfTwoSorted(B, A)
    
    low = 0
    hi = n1
    left = (n1+n2+1) // 2

    while (low<=hi):
         
        midA = (low + hi) // 2
        midB = left - midA

        l1 = A[midA-1] if midA > 0 else float('-inf')
        l2 = B[midB-1] if midB > 0 else float('-inf')
        r1 = A[midA] if midA < len(A) else float('inf')
        r2 = B[midB] if midB < len(B) else float('inf')

        if (l1<=r2 and l2<=r1):
            if (n1+n2) % 2 == 0:
                return (max(l1, l2) + min(r1, r2)) / 2.0
            else:
                return max(l1, l2)
        elif (l1>r2):
            hi = midA - 1
        elif(l2 > r1):
            low = midA + 1