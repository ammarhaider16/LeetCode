class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if (x < 1):
            return 0
        if (x < 4):
            return 1
        
        lower = 1
        upper = x // 2
        closestLower = 1

        while (lower <= upper):
            middle = (lower+upper) // 2
            sq = middle*middle
            if (sq == x):
                return middle
            if (sq > x):
                upper = middle - 1
            if (sq < x):
                lower = middle + 1
                closestLower = middle
        
        return closestLower