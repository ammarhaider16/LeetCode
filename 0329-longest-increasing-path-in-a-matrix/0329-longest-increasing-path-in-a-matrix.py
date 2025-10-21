class Solution:
    def longestIncreasingPath(self, matrix) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [[0]*n for _ in range(m)]
        items = [(i, j) for i in range(m) for j in range(n)]
        items.sort(key=lambda x:-matrix[x[0]][x[1]])
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  
        max_path_length = 0
        for i, j in items:
            max_higher_path = 0
            for dy, dx in directions:
                point = i + dy, j + dx
                if (0 <= point[0] < m and 0 <= point[1] < n) and (matrix[point[0]][point[1]] > matrix[i][j]) and (dp[point[0]][point[1]] > max_higher_path):
                    max_higher_path = dp[point[0]][point[1]]
            dp[i][j] = 1 + max_higher_path
            if dp[i][j] > max_path_length:
                max_path_length = dp[i][j]
        return max_path_length