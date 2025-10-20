from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:	
        m, n = len(grid), len(grid[0])
        bfs_q = deque()
        distances = {}
        visited = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    distances[(i, j)] = float('inf')
                elif grid[i][j] == 2:
                    bfs_q.append((0, (i, j)))
                    visited.add((i, j))
        if len(distances) == 0: 
            return 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def is_valid(point):
            return True if 0<=point[0]<m and 0<=point[1]<n and grid[point[0]][point[1]] != 0 else False

        while bfs_q:
            distance_from_2, current = bfs_q.popleft()
            if current in distances and distance_from_2 < distances[current]:
                distances[current] = distance_from_2
            for dy, dx in directions:
                neighbor = current[0] + dy, current[1] + dx
                if is_valid(neighbor) and neighbor not in visited:
                    bfs_q.append((distance_from_2 + 1, neighbor))
                    visited.add(neighbor)

        min_time = max(distances.values())
        return min_time if min_time < float('inf') else -1	
