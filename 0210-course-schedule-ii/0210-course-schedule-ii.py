from collections import deque

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]):
        edges_into = {i : 0 for i in range(numCourses)}
        graph = {i: set() for i in range(numCourses)}
        for child, parent in prerequisites:
            edges_into[child] += 1
            graph[parent].add(child) 
        order = []
        queue = deque()
        for vertex, edges in edges_into.items():
            if edges == 0:
                queue.append(vertex)
        while len(queue) > 0:
            vertex = queue.popleft()
            order.append(vertex)
            for neighbor in graph[vertex]:
                edges_into[neighbor] -= 1 
                if edges_into[neighbor] == 0:
                    queue.append(neighbor)
        if len(order) != len(graph):
            return []
        return order

