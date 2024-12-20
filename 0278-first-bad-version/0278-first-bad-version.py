# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """

        start = 1
        end = n
        FBV = n

        while (start<=end):
            middle = (start+end) // 2
            if isBadVersion(middle):
                end = middle - 1
                FBV = middle
            else:
                start = middle+1
        return FBV