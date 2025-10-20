from heapq import heappush, heappop

class Solution:
    def swimInWater(self, grid):
        n = len(grid)
        costs = {(i, j): float('inf') for i in range(n) for j in range(n)}
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        pq = []
        costs[(0, 0)] = grid[0][0] 
        heappush(pq, (grid[0][0], (0, 0)))

        while pq:
            current_cost, current = heappop(pq)
            if current_cost > costs[current]:
                continue
            for dy, dx in directions:
                new = current[0] + dy, current[1] + dx
                if not (0 <= new[0] < n and 0 <= new[1] < n):
                    continue
                new_cost = max(current_cost, grid[new[0]][new[1]])
                if new_cost < costs[new]:
                    costs[new] = new_cost
                    heappush(pq, (new_cost, new))
                    
        return costs[(n-1, n-1)]

