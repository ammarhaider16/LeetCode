class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0]*n for _ in range(m)]  # sets up a mxn DP array
        dp[m-1][n-1] = grid[m-1][n-1] # potential mistake avoided
        for i in range(n-2, -1, -1):
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1]
        for i in range(m-2, -1, -1):
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1]
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])
        return dp[0][0]