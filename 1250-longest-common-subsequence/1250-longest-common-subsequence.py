class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        n = len(text1)
        m = len(text2)
        dp = [[0]*(m+1) for _ in range(n+1)]

        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                A = dp[i+1][j+1] + (1 if text1[i] == text2[j] else 0)
                B = dp[i][j+1]
                C = dp[i+1][j]
                dp[i][j] = max(A, B, C)
        
        return dp[0][0]


