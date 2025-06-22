# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if not root:
            return []
    
        traversal = [] # Will need to check if list for level exists in this 2D array 
        bfsQueue = deque() # Items entered in format (node, level), level is 0-based        
        # Init traversal
        bfsQueue.appendleft((root, 0))
        # Traversal loop
        while len(bfsQueue) > 0:
            (node, level) = bfsQueue.pop()
            # Add current node to traversal
            if len(traversal) < (level + 1):
                traversal.append([])
            traversal[level].append(node.val)
            # Add children to queue
            if node.left:
                bfsQueue.appendleft((node.left, level + 1))
            if node.right:
                bfsQueue.appendleft((node.right, level + 1))
        return traversal
