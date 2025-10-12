class Solution:
    def cloneGraph(self, node):
        if not node:
            return None
        
        start = Node(node.val)
        visited = {}
        def copy_dfs(current_copy_node, current_original_node):
            visited[current_copy_node.val] = current_copy_node
            for neighbor in current_original_node.neighbors:
                if neighbor.val in visited:
                    current_copy_node.neighbors.append(visited[neighbor.val])
                else:
                    new_copy_neighbor = Node(neighbor.val)
                    current_copy_node.neighbors.append(new_copy_neighbor)
                    copy_dfs(new_copy_neighbor, neighbor)
        copy_dfs(start, node)
        return start
