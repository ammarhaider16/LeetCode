class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        visited = set()
        max_area = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def area_dfs(point):
            if point in visited or grid[point[0]][point[1]] != 1:
                return 0
            visited.add(point)
            area = 1 

            for direction in directions:
                neighbor = (point[0] + direction[0], point[1] + direction[1])
                if self.validate_index(neighbor, n, m):
                    area += area_dfs(neighbor)
            return area

        for i in range(n):
            for j in range(m):
                area_from_point = area_dfs((i, j))
                if area_from_point > max_area: 
                    max_area = area_from_point
        return max_area

    def validate_index(self, point, n, m):
        return True if (point[0] >= 0 and point[0] < n and point[1] >= 0 and point[1] < m) else False
