from collections import deque

class Solution:
    def findCheapestPrice(self, n, flights, src, dst, k):
        graph = {i : {} for i in range(n)}  # Assuming 0 based indexing
        costs = {i: float('inf') for i in range(n)}
        for v_from, v_to, price in flights:
            graph[v_from][v_to] = price

        bfs_q = deque()
        bfs_q.append((0, 0, src))
        min_cost = float('inf')
        while bfs_q:
            current_stops, current_cost, current_vertex = bfs_q.popleft()
            if current_vertex == dst and current_cost < min_cost:
                    min_cost = current_cost
                    continue
            if costs[current_vertex] <= current_cost:
                continue
            costs[current_vertex] = current_cost 
            if current_stops > k:
                continue
            for neighbor, price in graph[current_vertex].items():
                new_stops, new_cost = current_stops + 1, current_cost + price
                bfs_q.append((new_stops, new_cost, neighbor))

        return min_cost if min_cost < float('inf') else -1	