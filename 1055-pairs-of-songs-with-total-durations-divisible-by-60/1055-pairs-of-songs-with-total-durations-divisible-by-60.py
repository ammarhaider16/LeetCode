class Solution(object):
    def numPairsDivisibleBy60(self, time):
        """
        :type time: List[int]
        :rtype: int
        """
        remainders = {}
        numPairs = 0
        for dur in time:
            remainder = dur%60
            
            if remainder>0 and (60-remainder in remainders):
                numPairs+=remainders.get(60-remainder)
            elif remainder == 0 and 0 in remainders:
                numPairs+=remainders.get(0)

            if (remainder in remainders):
                remainders[remainder] =  remainders.get(remainder)+1
            else:
                remainders[remainder] = 1

        return numPairs

        