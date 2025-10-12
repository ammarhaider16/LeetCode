class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not len(grid) or not len(grid[0]):
            return 0
        n, m = len(grid), len(grid[0])
        starting_points = []

        # Populate starting points
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    starting_points.append((i, j))
                elif grid[i][j] != 0:
                    raise ValueError("Input should contain 1s and 0s only!")
        
        visited = set()
        max_area = 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def area_dfs(point):
            if point in visited:
                return 0
            visited.add(point)
            area = 1 
            # chance of mistake in area calculation if you visualize the dfs incorrectly -- this captures edge cases of no more neigbors, prevents double counting, also safe because fun called on this point only when point is 1 and the 1 in this point has not contributed to the area
            for direction in directions:
                neighbor = (point[0] + direction[0], point[1] + direction[1])
                if self.validate_index(neighbor, n, m) and grid[neighbor[0]][neighbor[1]] == 1:
                    area += area_dfs(neighbor)
            return area

        for point in starting_points:
            area_from_point = area_dfs(point)
            if area_from_point > max_area: 
                max_area = area_from_point
        
        return max_area

    # Need index validation for DFS
    def validate_index(self, point, n, m):
        return True if (point[0] >= 0 and point[0] < n and point[1] >= 0 and point[1] < m) else False
