from collections import deque

class Solution:
    def findCheapestPrice(self, n, flights, src, dest, k):
        graph = {i: {} for i in range(n)}
        for u, v, w in flights:
            graph[u][v] = w
        
        queue = deque([(src, 0, 0)])  # node, cost, stops
        best = {(src, 0): 0}  # (node, stops) -> min cost
        min_price = float('inf')
        
        while queue:
            node, cost, stops = queue.popleft()
            
            # If destination reached, update min price
            if node == dest:
                min_price = min(min_price, cost)
                continue
            
            if stops > k:
                continue
            
            for nei, price in graph[node].items():
                new_cost = cost + price
                if new_cost > min_price:
                    continue 
                
                if (nei, stops + 1) not in best or new_cost < best[(nei, stops + 1)]:
                    best[(nei, stops + 1)] = new_cost
                    queue.append((nei, new_cost, stops + 1))
        
        return min_price if min_price != float('inf') else -1
