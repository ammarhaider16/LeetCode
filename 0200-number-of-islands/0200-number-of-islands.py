from collections import deque
class Solution:
    def numIslands(self, grid):
        starting_points = []

        if len(grid) == 0 or len(grid[0]) == 0:
            return 0

        n, m = len(grid), len(grid[0])
        # Populate starting points
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    starting_points.append((i, j))

        num_islands = 0
        directions = [(0, -1), (0, 1), (1, 0), (-1, 0)]
        visited = set()
        bfs_q = deque()
        # BFS for every valid potential starting point
        for starting_point in starting_points:
            if starting_point in visited:
                continue # mistake avoided of overcounting
            num_islands += 1
            bfs_q.append(starting_point)

            while len(bfs_q) > 0:
                point = bfs_q.popleft()
                if point in visited:
                    continue
                visited.add(point)
                for direction in directions:
                    neighbor = (point[0] + direction[0], point[1] + direction[1])
                    # prevent invalid indeing and verifying if this is good to proceed
                    if self.is_index_valid(neighbor, n, m) and grid[neighbor[0]][neighbor[1]] == "1":
                        bfs_q.append(neighbor)
        return num_islands

    def is_index_valid(self, point, n, m):
        if point[0] >= 0 and point[1] >= 0 and point[0] < n and point[1] < m:
            return True	
        return False

