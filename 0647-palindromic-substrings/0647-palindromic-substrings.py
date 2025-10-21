class Solution:
    def countSubstrings(self, s: str) -> int:
        count, n = len(s), len(s)
        dp = [[False]*n for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                count += 1
        for size in range(3, n+1):
            for i in range(n - size + 1):
                if s[i] == s[i+size-1] and dp[i+1][i+size-2]:
                    count += 1
                    dp[i][i+size-1] = True
        return count