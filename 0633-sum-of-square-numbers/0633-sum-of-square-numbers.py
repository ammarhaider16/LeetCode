class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        if (c<=2):
            return True
    
        start = 1
        end = c // 2
        return judgePerfectSquareHelper(start, end, c)


def judgePerfectSquareHelper(start, end, c):
    while(start<=end):
            middle = (start+end) // 2
            aSq = middle*middle
            if (aSq > c):
                end = middle - 1
            elif (aSq == c):
                return True
            else:
                bSq = c - aSq
                if isPerfectSquare(bSq):
                    return True
                else:
                    return judgePerfectSquareHelper(start, middle-1, c) or judgePerfectSquareHelper(middle+1, end, c)
    return False 
        

def isPerfectSquare(num):
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