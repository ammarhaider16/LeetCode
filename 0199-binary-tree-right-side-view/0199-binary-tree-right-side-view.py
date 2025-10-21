from collections import deque

class Solution:
    def rightSideView(self, root):
        right = []
        bfs_q = deque()
        if root:
            bfs_q.append(root)
        current_level = -1
        while bfs_q:
            right.append(0)
            current_level += 1
            size = len(bfs_q)	
            for _ in range(size):
                current = bfs_q.popleft()
                right[current_level] = current.val
                if current.left:
                    bfs_q.append(current.left)
                if current.right:
                    bfs_q.append(current.right)
        return right 