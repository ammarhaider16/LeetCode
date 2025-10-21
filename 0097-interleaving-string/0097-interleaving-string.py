class Solution:
    def isInterleave(self, s1:str, s2:str, s3:str) -> bool:
        m, n = len(s1), len(s2)
        if m+n != len(s3):
            return False
        dp = [[False] * (n+1) for _ in range(m+1)]
        dp[0][0] = True
        for i in range(1, m+1):
            dp[i][0] = True if s1[:i] == s3[:i] else False
        for j in range(1, n+1): 
            dp[0][j] = True if s2[:j] == s3[:j] else False
        for i in range(1, m+1):
            for j in range(1, n+1):
                dp[i][j] = True if ((s3[i+j-1] == s1[i-1] and dp[i-1][j]) or (s3[i+j-1] == s2[j-1] and dp[i][j-1])) else False
        return dp[m][n]