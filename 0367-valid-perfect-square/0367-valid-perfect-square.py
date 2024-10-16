class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if (num == 1):
            return True
        if (num<4):
            return False
        
        lower = 1
        upper = num // 2

        while(lower<=upper):
            middle = (lower+upper)//2    
            sq = middle*middle
            if (num == sq):
                return True
            elif (sq>num):
                upper = middle - 1
            else:
                lower = middle + 1    
        return False
