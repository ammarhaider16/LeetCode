# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        BFSqueue = deque()
        traversal = []  
        
        BFSqueue.appendleft((root, 0))
        while len(BFSqueue) > 0:
            node, level = BFSqueue.pop()
            if len(traversal) < level + 1:
                traversal.append([])
            traversal[level].append(node.val)
            if node.left:
                BFSqueue.appendleft((node.left, level + 1))
            if node.right:
                BFSqueue.appendleft((node.right, level + 1))

        traversal.reverse()
        return traversal
